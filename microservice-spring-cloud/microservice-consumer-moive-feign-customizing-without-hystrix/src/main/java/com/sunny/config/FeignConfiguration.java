package com.sunny.config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

    /**
     * 添加日志需要添加的bean
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
