### Spring的JDBC操作类
*   spring-jdbc
    *   core, JdbcTemplate等相关核心接口和类
    *   datasource, 数据源相关的辅助类
    *   object, 将基本的JDBC操作封装成对象
    *   support, 错误码等其他辅助工具

### 常用的Bean注解
*   通过注解定义Bean
    *   @Component: 定义通用 bean
    *   @Repository：定义数据库操作的 bean
    *   @Service：定义业务服务 bean
    *   @Controller：定义MVC bean
    *   @RestController：定义 Rest 入口 bean

### 简单的JDBC操作
*   JdbcTemplate
    *   query
    *   queryForObject
    *   queryForList
    *   update
    *   execute

### SQL批处理
*   Jdbc Template
    *   batchUpdate
    *   BatchPreparedStatementSetter
*   NamedParameterJdbcTemplate
    *   batchUpdate
    *   SqlParameterSourceUtils.createBatch
