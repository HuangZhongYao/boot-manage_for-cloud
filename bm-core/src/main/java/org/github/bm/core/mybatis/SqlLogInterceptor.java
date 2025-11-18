package org.github.bm.core.mybatis;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.SystemClock;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;

import java.lang.reflect.Method;
import java.sql.Statement;
import java.util.*;

/**
 * 用于输出每条 SQL 语句及其执行时间
 *
 * @author hubin nieqiurong TaoYu
 * @since 2016-07-07
 */
@Slf4j
@Intercepts({
		@Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
		@Signature(type = StatementHandler.class, method = "update", args = Statement.class),
		@Signature(type = StatementHandler.class, method = "batch", args = Statement.class)
})
public class SqlLogInterceptor implements Interceptor {
	private static final String DRUID_POOLED_PREPARED_STATEMENT = "com.alibaba.druid.pool.DruidPooledPreparedStatement";
	private static final String T4C_PREPARED_STATEMENT = "oracle.jdbc.driver.T4CPreparedStatement";
	private static final String ORACLE_PREPARED_STATEMENT_WRAPPER = "oracle.jdbc.driver.OraclePreparedStatementWrapper";

	private Method oracleGetOriginalSqlMethod;
	private Method druidGetSqlMethod;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Statement statement = (Statement) invocation.getArgs()[0];
		MetaObject stmtMetaObj = SystemMetaObject.forObject(statement);

		// 修复：不依赖 Proxy.h 字段，通过层层unwrap获取真实Statement（兼容代理对象）
		statement = unwrapRealStatement(statement, stmtMetaObj);

		String originalSql = null;
		String stmtClassName = statement.getClass().getName();

		//  Druid 连接池适配
		if (DRUID_POOLED_PREPARED_STATEMENT.equals(stmtClassName)) {
			try {
				if (druidGetSqlMethod == null) {
					Class<?> clazz = Class.forName(DRUID_POOLED_PREPARED_STATEMENT);
					druidGetSqlMethod = clazz.getMethod("getSql");
				}
				Object stmtSql = druidGetSqlMethod.invoke(statement);
				if (stmtSql instanceof String) {
					originalSql = (String) stmtSql;
				}
			} catch (Exception e) {
				log.error("Druid 获取SQL失败", e);
			}
		}
		// Oracle 驱动适配
		else if (T4C_PREPARED_STATEMENT.equals(stmtClassName) || ORACLE_PREPARED_STATEMENT_WRAPPER.equals(stmtClassName)) {
			try {
				if (oracleGetOriginalSqlMethod == null) {
					Class<?> clazz = Class.forName(stmtClassName);
					oracleGetOriginalSqlMethod = getMethodRegular(clazz, "getOriginalSql");
					if (oracleGetOriginalSqlMethod != null) {
						oracleGetOriginalSqlMethod.setAccessible(true);
					}
				}
				if (oracleGetOriginalSqlMethod != null) {
					Object stmtSql = oracleGetOriginalSqlMethod.invoke(statement);
					if (stmtSql instanceof String) {
						originalSql = (String) stmtSql;
					}
				}
			} catch (Exception e) {
				log.error("Oracle 获取SQL失败", e);
			}
		}

		// 兜底：如果以上方式都获取不到，直接用 Statement.toString()
		if (originalSql == null) {
			originalSql = statement.toString();
		}

		// 格式化 SQL（去除多余空格）
		originalSql = originalSql.replaceAll("[\\s]+", StringPool.SPACE);
		int index = indexOfSqlStart(originalSql);
		if (index > 0) {
			originalSql = originalSql.substring(index);
		}

		// 计算执行耗时
		long start = SystemClock.now();
		Object result = invocation.proceed();
		long timing = SystemClock.now() - start;

		// 打印 SQL 日志
		Object target = PluginUtils.realTarget(invocation.getTarget());
		MetaObject metaObject = SystemMetaObject.forObject(target);
		MappedStatement ms = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
		System.err.printf(
				"\n==============  Sql Start  ==============" +
						"\nExecute ID  ：%s" +
						"\nExecute SQL ：%s" +
						"\nExecute Time：%s ms" +
						"\n==============  Sql  End   ==============\n",
				ms.getId(), originalSql, timing
		);

		return result;
	}

	/**
	 * 修复核心：递归unwrap获取真实的Statement（兼容代理对象和各种连接池包装类）
	 */
	private Statement unwrapRealStatement(Statement statement, MetaObject stmtMetaObj) {
		try {
			// 处理 Hikari 连接池的 delegate 包装
			if (stmtMetaObj.hasGetter("delegate")) {
				Object delegate = stmtMetaObj.getValue("delegate");
				if (delegate instanceof Statement) {
					return unwrapRealStatement((Statement) delegate, SystemMetaObject.forObject(delegate));
				}
			}
			// 处理 stmt.statement 格式的包装（如部分连接池）
			if (stmtMetaObj.hasGetter("stmt.statement")) {
				Object innerStmt = stmtMetaObj.getValue("stmt.statement");
				if (innerStmt instanceof Statement) {
					return unwrapRealStatement((Statement) innerStmt, SystemMetaObject.forObject(innerStmt));
				}
			}
			// 处理 Java 标准的 Wrapper 接口（JDBC 规范）
			if (statement instanceof java.sql.Wrapper) {
				try {
					// 尝试unwrap为PreparedStatement（如果是PreparedStatement的话）
					return ((java.sql.Wrapper) statement).unwrap(Statement.class);
				} catch (Exception e) {
					// 如果unwrap失败，返回原始statement
					return statement;
				}
			}
		} catch (Exception e) {
			log.error("unwrap真实Statement失败", e);
		}
		return statement;
	}

	@Override
	public Object plugin(Object target) {
		if (target instanceof StatementHandler) {
			return Plugin.wrap(target, this);
		}
		return target;
	}

	/**
	 * 获取指定方法名的Method（递归查找父类）
	 */
	private Method getMethodRegular(Class<?> clazz, String methodName) {
		if (Object.class.equals(clazz)) {
			return null;
		}
		for (Method method : clazz.getDeclaredMethods()) {
			if (method.getName().equals(methodName)) {
				return method;
			}
		}
		return getMethodRegular(clazz.getSuperclass(), methodName);
	}

	/**
	 * 找到SQL语句的起始位置（SELECT/INSERT/UPDATE/DELETE）
	 */
	private int indexOfSqlStart(String sql) {
		String upperCaseSql = sql.toUpperCase();
		Set<Integer> set = new HashSet<>();
		set.add(upperCaseSql.indexOf("SELECT "));
		set.add(upperCaseSql.indexOf("UPDATE "));
		set.add(upperCaseSql.indexOf("INSERT "));
		set.add(upperCaseSql.indexOf("DELETE "));
		set.remove(-1);
		if (CollectionUtils.isEmpty(set)) {
			return -1;
		}
		List<Integer> list = new ArrayList<>(set);
		list.sort(Comparator.naturalOrder());
		return list.get(0);
	}
}