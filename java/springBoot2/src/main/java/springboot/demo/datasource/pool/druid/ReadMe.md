# [Druid](https://github.com/alibaba/druid)

    经过阿里巴巴各大系统的考验，值得信赖
## 连接池选择时的考量点
   
   可靠性、性能、功能、可运维性、可扩展性、其他
   
## 实用的功能
*   详细的监控(真的是全面)
*   ExceptionSorter, 针对主流数据库的返回码都有支持
*   SQL 防注入
*   内置加密配置
*   众多扩展点，方便进行定制

## 数据源配置
*   直接配置 DruidDataSource
*   通过 druid-spring-boot-starter 配置 **spring.datasource.druid.***
```properties
spring.output.ansi.enabled=ALWAYS
spring.datasource.url=jdbc:h2:mem:foo
spring.datasource.username=sa
spring.datasource.password=n/z7PyA5cvcXvs8……lpCAPc3MqsGvsrxVJw==
spring.datasource.druid.initial-size=5
spring.datasource.druid.max-active=5
spring.datasource.druid.min-idle=5
spring.datasource.druid.filters=conn,config,stat,slf4j
spring.datasource.druid.connection-properties=config.decrypt=true;config.decrypt.key=${public-key}
spring.datasource.druid.filter.config.enabled=true
spring.datasource.druid.test-on-borrow=true
spring.datasource.druid.test-on-return=true
spring.datasource.druid.test-while-idle=true
```

*   Filter配置
```properties
spring.datasource.druid.filters=stat,config,all,og4j (全部使用默认值)
```
*   密码加密
```properties
spring.datasource.password=<加密密码>
spring.datasource.druid.filter.config.enabled=true
spring.datasource.druid.connection-properties=config.decrypt-true;config.decrypt.key=<public-key>
```
*   SQL防注入
```properties
spring.datasource.druid.filter.wall.enabled=true
spring.datasource.druid.filter.wall.db-type=h2
spring.datasource.druid.filter.wall.config.delete-allow=false
spring.datasource.druid.filter.wall.config.drop-table-allow=false
```
### DruidFilter

    ●   用于定制连接池操作的各种环节
    ●   可以继承 FilterEventAdapter 以便方便地实现Filter
    ●   修改META-INF/druid-filter.properties增加Filter配置

```java
//在连接前后打印日志
@Slf4j
public class ConnectionLogFilter extends FilterEventAdapter {
    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        log. info("BEFORE CONNECTION!");
    }
    @Override
    public void connection_connectAfter(ConnectionProxy connection) {
        log. info("AFTER CONNECTION!");
    }
}
```
