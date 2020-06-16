### 常用JPA注解
#### 实体
*   @Entity、@MappedSuperclass
*   @TabLe(name)
#### 主键
*   @Id
*   @GeneratedValue(strategy, generator)
*   @SequenceGenerator(name，sequenceName)
#### 映射
*   @Column(name，nullabLe, Length, insertable, updatable)
*   @JoinTable(name)、@JoinColumn(name)
#### 关系
*   @OneToOne、@OneToMany、 @ManyToOne、 @ManyToMany
*   @OrderBy

### 运行MyBatis Generator
*   命令行

    java -jar mybatis-generator-core-x.x.x.jar -configfile generatorConfig.xml
   
*   Maven Plugin (mybatis-generator-maven-plugin)
    
    mvn mybatis-generator:generate
    ${basedir}/src/main/resources/generatorConfig.xml
    
*   Eclipse Plugin
*   Java程序
*   Ant Task
