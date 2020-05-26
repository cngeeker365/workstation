package springboot.demo;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@SpringBootApplication // = @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
@ServletComponentScan
@MapperScan("springboot.demo.day02.mybatis.mapper")    //开启Mapper扫描
@EnableScheduling   //开启定时任务
@EnableAsync        //开启异步任务
@EnableJms          //开启支持jms
public class DemoApplication extends SpringBootServletInitializer {



    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(DemoApplication.class);
    }

    public static void main(String[] args) {
        /**
         * Springboot整合Elasticsearch 在项目启动前设置一下的属性，防止报错
         * 解决netty冲突后初始化client时还会抛出异常
         * java.lang.IllegalStateException: availableProcessors is already set to [4], rejecting [4]
         */
        System.setProperty("es.set.netty.runtime.available.processors", "false");

        SpringApplication.run(DemoApplication.class, args);
    }

    //==================================================ActiveMQ配置=============================================
    @Bean //交给Spring进行管理，方便后续进行注入
    public Queue queue(){
        return new ActiveMQQueue("common.queue");
    }

    @Bean //主题对象交给Spring管理
    public Topic topic(){
        return new ActiveMQTopic("video.topic");
    }

    @Bean //支持发布订阅的Listener工厂
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }

}
