# HikariCP
## 为什么这么快？
1.字节码级别优化(很多方法通过JavaAssist生成)

2.大量小改进
*   用FastStatementList代替ArrayL ist
*   无锁集合ConcurrentBag
*   代理类的优化(比如，用invokestatic代替了invokevirtual)

## 在 SpringBoot 中配置
*   Spring Boot 2.x
    *   默认使用HikariCP
    *   配置 spring.datasource.hikari.* 参数
        *   常见配置
            *   spring,datasource.hikari.maximumPoolSize=10
            *   spring.datasource.hikari.minimumIdle=10
            *   spring.datasource.hikari.idleTimeout=600000
            *   spring.datasource.hikari.connectionTimeout=30000
            *   spring.datasource.hikari.maxLifetime=1800000
        *   其他配置详见HikariCP官网
            *   https://github.com/brettwooldridge/HikariCP
```java
/**
 * Hikari DataSource configuration.
 */
@ConditionalOnClass (HikariDataSource.class)
@ConditionalOnMissingBean(DataSource.class)
@ConditionalOnProperty(name = "spring.datasource.type", havingValue = "com.zaxxer.hikari.HikariDataSource", matchIfMissing=true)
static class Hikari {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariDataSource dataSource (DataSourceProperties properties){
        HikariDataSource dataSource = createDataSource(properties, HikariDataSource.class); 
        if (StringUtils.hasText(properties.getName())) {
            dataSource.setPoolName(properties.getName());
        }
        return dataSource ;
    }
}

```

*   Spring Boot 1.x
    *   默认使用Tomcat连接池，需要移除tomcat-jdbc依赖
    *   spring.datasource.type=com.zaxxer.hikari.HikariDataSource

