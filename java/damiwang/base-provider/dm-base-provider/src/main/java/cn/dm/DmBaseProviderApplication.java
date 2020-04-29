package cn.dm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan({"cn.dm.mapper"})
public class DmBaseProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmBaseProviderApplication.class, args);
    }

}
