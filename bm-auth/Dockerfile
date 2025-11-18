# 基础镜像：使用轻量的 Alpine 版 OpenJDK 17 JRE
FROM eclipse-temurin:17-jre-alpine

# 镜像元信息：维护者信息
MAINTAINER pisleo@yeah.net

# 设置工作目录（后续指令默认在此目录执行，提前创建可避免权限问题）
WORKDIR /bm/auth

# target 目录下的 JAR 包到容器（通配符匹配版本号变动的 JAR）
COPY target/bm-auth-*.jar ./app.jar

# 声明容器对外暴露的端口（文档性说明，实际映射需通过 docker run -p 指定）
EXPOSE 8190

# 容器启动命令（固定入口点，支持通过 docker run 追加参数，如指定环境 例：docker run -d 镜像名 --spring.profiles.active=prod）
ENTRYPOINT ["java", "-jar", "app.jar"]

# 默认容器启动参数
CMD ["--spring.profiles.active=prod"]