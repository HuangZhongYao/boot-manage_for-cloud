<p align="center">
  <a href="https://github.com/HuangZhongYao/boot-manage_for-cloud">
    <img alt="Boot Manage Admin Logo" width="200" src="./doc/picture/logo.png">
  </a>
</p>
<p align="center">
  <a href="./LICENSE">
    <img alt="MIT License" src="./doc/picture/license.svg"/>
  </a>
  <a href="https://github.com/HuangZhongYao/boot-manage_for-cloud" >
    <img alt="GitHub" width="20" src="./doc/picture/github.svg" >
  </a>
  <a href="https://gitee.com/smog_huang/boot-manage_for-cloud" >
    <img alt="Gitee" width="20" src="./doc/picture/gitee.svg" >
  </a>
</p>

# boot-manage (bm 后台管理系统模板--cloud版)

## 一、项目介绍
boot-manage admin 是一款极简风格的微服务架构后台管理模板。    
后端基于Java17、SpringBoot 3、SpringCloud Alibaba 轻量级实现只需要安装Nacos、Redis、MySQL即可启动。
内置集成分布式事务、流量控制组件开箱即用  
前端使用 Vite + Vue3 + Naive UI + Pinia + Unocss + 无 Typescript降低门槛。

#### 技术栈
- <img width="20" src="./doc/picture/java.svg" > Java 17
- <img width="20" src="./doc/picture/springboot.svg" > SpringBoot 3.2.x
- <img width="20" src="./doc/picture/mybatis.svg" > Mybatis-Plus
- <img width="16" src="./doc/picture/jwt.svg" > JWT
- <img width="20" src="./doc/picture/swagger.svg" > knife4j-ui + Swagger 3
- <img width="20" src="./doc/picture/redis.svg" > Redis
- <img width="20" src="./doc/picture/mysql.svg" > MySQL 8

#### 特性
- 😋 遵守Restful API风格 。
- 😀 使用当前最新技术 Java17 + SpringBoot 3.x 。
- 😉 封装参数验证注解 ，基于`validation`封装常用非空、手机号、车牌号、邮箱、中文、非中文、IP、MAC... 常见类型数据参数验证, 减少90%校验参数代码。 源码中几乎很少看到判断参数的代码。
- 🍗 封装通用DTO ， 对于基础字段无需重复定义只需继承 `BaseXXXDTO`。
- 🤣 扩展Mybatis BaseMapper 查询结果转换类型、函数处理、批量操作。
- 🍔 封装`mapstruct`、`modelmapper`对象转换工具 ， VO、DTO、Entity之间互相转换一行代码搞定，结合函数式接口还可以在转换时添加逻辑。
- ⏲  LocalDateTime ， 日期类型使用Java8 更安全的LocalDateTime， 配置jackson消息转换器解决Java8 LocalDateTime序列化时`'T'`。

#### 配套前端
前端项目使用Vue3 + JavaScript 构建  

技术栈:
- <img width="16" src="./doc/picture/vue.svg" > Vue 3
- <img width="20" src="./doc/picture/pinia.svg" > Pinia
- <img width="16" src="./doc/picture/naiveui.svg" > Naive ui
- <img width="20" src="./doc/picture/unocss.svg" > Unocss

源码
- 源码 GitHub: [https://github.com/HuangZhongYao/boot-manage-ui_for-cloud](https://github.com/HuangZhongYao/boot-manage-ui_for-cloud)
- 源码 Gitee: [https://gitee.com/smog_huang/boot-manage-ui_for-cloud](https://gitee.com/smog_huang/boot-manage-ui_for-cloud)

## 二、架构图
![BM架构图.png](doc/picture/BM%E6%9E%B6%E6%9E%84%E5%9B%BE.png)

## 三、项目结构

```text
├─bm-auth                                                           #认证服务
├─bm-common                                                         #公共模块 工具类、常量、枚举、基类、启动器等
├─bm-core                                                           #核心配置模块 mybatis-plus、redis、mvc、过滤器、全局异常处理等配置
├─bm-gateway                                                        #网关服务
├─bm-ops                                                            #Devops服务合集 如调度中心、监控服务、日志服务
│  └─bm-admin                                                       #SpringBoot Admin服务 监控和管理Spring Boot应用
├─bm-service                                                        #微服务合集
│  ├─bm-example                                                     #example服务 演示模块
│  ├─bm-resource                                                    #资源服务 管理文件、数据源、短信配置、邮件配置等
│  ├─bm-system                                                      #系统服务 字典、组织、角色、菜单、公告通知等
│  ├─bm-user                                                        #用户服务 用户管理
│  └─bm-websocket                                                   #socket服务 长链接消息推送、在线用户管理
├─bm-service-api                                                    #服务对外暴露api合集 FeignClient、实体、DTO、VO等
│  ├─bm-example-api                                                 #example服务api
│  ├─bm-resource-api                                                #资源服务api
│  ├─bm-system-api                                                  #系统服务api
│  ├─bm-user-api                                                    #用户服务api
│  └─bm-websocket-api                                               #socket服务api
└─doc                                                               #文档
│   ├─nacos                                                         #Nacos 初始化配置
│   │─nginx                                                         #Nnginx 配置
│   │─seata                                                         #Seata 配置
│   │  │─application.yml                                            #Seata 配置文件
│   │  │─seata-2.0.0.sql                                            #seata 数据库初始化脚本
│   │  └─undo_log.sql                                               #undo_log表创建脚本
│   │─sql                                                           #SQL脚本
│   │  └─bm-initial-mysql.sql                                       #项目初始化脚本
└─README.md                                                         #项目自述文件
```

## 四、快速开始
### 环境要求
| 名称 | 版本     | 必要 | 说明 |
| --- |--------|----|--|
| JDK | &gt;= 17 | 是  | 建议JDK 17 |
| Maven | 3.8.x  | 是  |  |
| MySQL | 8.x.x  | 是  |  |
| Redis | 6.x.x  | 是  |  |
| Nacos | &gt;= 2.3.2 | 是  |  |
| Seata | &gt;= 2.0.0 | 否  | 建议2.0.0 非必要安装不影响启动 |
| Sentinel | &gt;= 1.8.6 | 否  | 非必要安装不影响启动 |

### 启动项目
#### 配置中间件
  - 初始化数据库  
    创建数据库`bm`字符集`utf8mb4`排序规则`utf8mb4_general_ci`并导入 [doc/bm-initial-mysql.sql](doc/sql/bm-initial-mysql.sql)
  - 启动Redis  
  - 启动Nacos  
    导入nacos配置[doc/nacos/]()目录下的配置
  - 启动Sentinel (可选)
  - 启动Seata (可选)
#### 修改配置
- nacos配置  
 修改`bm.yml` 中数据源、Redis 连接信息 
    ```yaml
    bm:
      # 安全配置
      security:
        # 跳过鉴权的uri路径
        skip-url:
         - /bm-example/**
         - /bm-websocket/**
         - /**/v3/api-docs
         - /**/v2/api-docs
         - /bm-auth/auth/login
         - /bm-auth/auth/refreshToken
         - /bm-datareport/ureport/**
         - /ureport/preview
         - /favicon.ico
         - /bm-auth/encryption/getEncryptionPublicKey
        token:
          # token密钥
          secret: "zuuzYao-bm.9d4c8b1e3f5d7a0b2c9d8e7f6a5b"
          # token前缀
          prefix: "Bearer "
        # 内部调用认证配置
        internal-valid:
          # 开启后服务调用只能由服务之间发起调用,外部不能调用! 适用于网关和服务都暴露在外网中情况
          enable: false
          # 认证令牌
          token: "bm-internal-token-zuuzYao-bm-Z2l0aHViLXp1dXVZYW8="
      # 定义数据源
      datasource:
        url: jdbc:mysql://127.0.0.1:3306/bm?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
        username: root
        password: "123456"
      # redis数据源
      data:
        redis:
          host: 127.0.0.1
          port: 6379
          password: 
          database: 15
    ```
- 启动常量 [LauncherConstant.java](bm-common/src/main/java/org/github/bm/common/launch/LauncherConstant.java)  
    修改dev环境Nacos启动参数   
    Sentinel 等不是必要的如果用到则配置,不配置也不影响项目启动
    ```java
    public interface LauncherConstant {
    
        interface NacosConstant {
            /**
             * nacos用户名如果开启认证则填写
             */
            String NACOS_USERNAME = "";
            /**
             * nacos密码如果开启认证则填写
             */
            String NACOS_PASSWORD = "";
            /**
             * nacos dev 命名空间 id ,为空为public
             */
            String NACOS_DEV_NAMESPACE = "9a019fa4-2b71-48d1-bf7c-23f4e4c0395a";
    
            /**
             * nacos test 命名空间 id ,为空为public
             */
            String NACOS_TEST_NAMESPACE = "3ae2a34e-8ac6-46c3-bcb5-1c4eb6195dcf";
    
            /**
             * nacos prod 命名空间 id ,为空为public
             */
            String NACOS_PROD_NAMESPACE = "a64b1361-f8c7-46d9-95c7-ea2ad9d336b4";
    
            /**
             * nacos dev 地址
             */
            String NACOS_DEV_ADDR = "127.0.0.1:8848";
    
            /**
             * nacos prod 地址
             */
            String NACOS_PROD_ADDR = "192.168.1.219:8848";
    
            /**
             * nacos test 地址
             */
            String NACOS_TEST_ADDR = "192.168.1.219:8848";
        }
    
        interface SentinelConstant {
            /**
             * sentinel dev 地址
             */
            String SENTINEL_DEV_ADDR = "127.0.0.1:8858";
    
            /**
             * sentinel prod 地址
             */
            String SENTINEL_PROD_ADDR = "192.168.1.219:8858";
    
            /**
             * sentinel test 地址
             */
            String SENTINEL_TEST_ADDR = "192.168.1.219:8858";
        }
    }
    ```
#### 启动服务
启动全部服务没有先后顺序
- 启动 网关服务`GateWayApplication`
- 启动 认证服务`AuthApplication`
- 启动 系统服务`SystemApplication`
- 启动 用户服务`UserApplication`
- 启动 资源服务`ResourceApplication`
- 启动 WebSocket服务`WebSocketApplication`
- 启动 Springboot监控服务`AdminApplication` 可选
- 启动 演示服务`ExampleApplication` 可选  


### 编译打包

```shell
# 全部打包
mvn clean package

# 打包指定模块 bm-gateway
mvn clean package -pl bm-gateway -am

# 打包指定模块 bm-system
mvn clean package -pl bm-service/bm-system -am

```




## 五、参考文档
#### SpringBoot、SpringCloud Alibaba、SpringCloud及组件[版本选择参考](https://sca.aliyun.com/docs/2023/overview/version-explain/)
![img.png](doc/picture/img.png)

#### 