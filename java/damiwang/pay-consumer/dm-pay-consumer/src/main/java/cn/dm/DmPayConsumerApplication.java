package cn.dm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;


@SpringBootApplication
@EnableDiscoveryClient  //开启服务发现客户端
@EnableCircuitBreaker  //启动断路器
//@SpringCloudApplication //可以取代上面三个
@EnableFeignClients
@EnableEurekaClient
public class DmPayConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmPayConsumerApplication.class, args);
    }

}




