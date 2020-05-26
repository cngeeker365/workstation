# Spring Boot 中的多数据源配置
## 方式一：配置主数据源 @Primary
## 方式二：排除 SpringBoot 的自动配置
*   exclude
    *   DataSourceAutoConfiguration
    *   DataSourceTransactionManagerAutoConfiguration
    *   JdbcTemplateAutoConfiguration

![多数据源代码示例](.ReadMe_images/多数据源代码示例.png)

![多数据源后beans变化](.ReadMe_images/beans页面.png)