```java
// 设置Hadoop程序运行的用户
System.setProperty("HADOOP_USER_NAME","root");
```
MR执行环境有两种：本地测试环境，服务器环境

# 方式一：本地测试环境（Windows）

    在Windows的Hadoop目录bin目录下面有一个winutils.exe
    1.  在Windows下配置Hadoop的环境变量
    2.  拷贝debug工具（winutils.exe）到HADOOP_HOME/bin
    3.  修改hadoop的源码，注意：确保项目的lib需要真实安装的JDK的lib
    4.  MR调用的代码需要改变：
        a.  src 不能有服务器的 Hadoop 配置文件
        b.  在调用时使用：
            Configuration conf = new Configuration();
            conf.get("fs.defaultFS", "hdfs://node7:8020");
            conf.get("yarn.resourcemanager.hostname","node7");


# 方式二：服务器环境

    首先，需要在 src 下放置服务器上的hadoop配置文件
    1.  在本地直接调用，执行过程在服务器上（真正企业运行环境）
        a.  把MR程序打包（jar），直接放到本地
        b.  修改hadoop的源码，注意：确保项目的lib需要真实安装的jdk的lib
        c.  增加一个属性：
            config.set("mapred.jar","c:\\Desktop\\wc.jar");
        d.  本地执行main方法，servlet调用MR
        
    2.  直接在服务器上，使用命令的方式调用，执行过程也在服务器上
        a.  把MR程序打包（jar），传送到服务器上
        b.  通过 hadoop jar jar路径 类的全限定名