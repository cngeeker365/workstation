package cn.dm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@MapperScan({"cn.dm.mapper"})
public class DmItemProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmItemProviderApplication.class, args);
    }

}
