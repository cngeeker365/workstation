package com.jdk.highLevel.nio;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

/**
 * @author taobaibai
 * @create 2020-04-06 16:12
 */
public class TestTomcat {

    public static void main(String[] args) throws Exception {
        //1. 构建Tomcat对象
        Tomcat tomcat = new Tomcat();
        //2. 构建 connector 对象，并指定协议
        //Tomcat 实用 connector 处理连接，一个Tomcat可以配置多个connector
        Connector connector = new Connector("HTTP/1.1");
        //3. 设置Tomcat监听端口
        connector.setPort(19999);
        tomcat.setConnector(connector);
        //启动Tomcat
        tomcat.start();
        tomcat.getServer().await();
    }
}
