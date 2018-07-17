package com.sunny.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
//添加feign注解
@EnableFeignClients
public class MicroserviceConsumerMoiveFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerMoiveFeignApplication.class, args);
	}
}
