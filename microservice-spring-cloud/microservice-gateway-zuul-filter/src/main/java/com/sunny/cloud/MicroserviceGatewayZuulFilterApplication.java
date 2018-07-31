package com.sunny.cloud;

import com.sunny.cloud.filter.PreZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class MicroserviceGatewayZuulFilterApplication {

	@Bean
	public PreZuulFilter preZuulFilter() {
		return new PreZuulFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGatewayZuulFilterApplication.class, args);
	}
}
