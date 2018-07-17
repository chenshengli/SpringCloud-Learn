package com.sunny.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.sunny.cloud.annotation.ExcludeFromComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//添加不扫描注解，若不用这种方法可以将这个文件放在启动类之外的包（包括子包也不行）里面
@ExcludeFromComponentScan
public class TestConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

}
