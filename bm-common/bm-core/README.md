## 核心配置模块
+ 项目启动类注解 [BMCloudApplication.java](src/main/java/org/github/bm/core/annotations/BMCloudApplication.java)
+ 自动配置Redis [RedisTemplateConfiguration.java](src/main/java/org/github/bm/core/redis/RedisTemplateConfiguration.java)
+ 自动配置Mybatis-Plus [MybatisPlusConfiguration.java](src/main/java/org/github/bm/core/mybatis/MybatisPlusConfiguration.java)
+ Feign请求配置，透传认证参数 [FeignConfiguration.java](src/main/java/org/github/bm/core/feign/FeignConfiguration.java)
+ Swagger 配置 [Knife4jSwaggerConfiguration.java](src/main/java/org/github/bm/core/knife4j/Knife4jSwaggerConfiguration.java)
+ 请求过滤配置 [RequestFilter.java](src/main/java/org/github/bm/core/filter/RequestFilter.java)
+ id生成器 [SnowflakeConfig.java](src/main/java/org/github/bm/core/generation/SnowflakeConfig.java)
+ 全局异常处理 [GlobalErrorController.java](src/main/java/org/github/bm/core/web/GlobalErrorController.java)
+ web配置 静态资源、消息转化器配置[WebMvcConfiguration.java](src/main/java/org/github/bm/core/web/WebMvcConfiguration.java)
+ 请求日志打印 [RequestLogAspect.java](src/main/java/org/github/bm/core/logger/RequestLogAspect.java)

！！注意因为有自动配置redis和mybaits-plus，所以需要配置相应数据源和redis连接参数。