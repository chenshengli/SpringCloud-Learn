package com.sunny.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sunny.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.SessionScope;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id}")
    //添加commandProperties使得请求的方法跟熔断回调的方法处于同一个线程里面，否则处于不同的线程,一般抛异常才需要配置
    @HystrixCommand(fallbackMethod = "findByIdFallback", commandProperties = {@HystrixProperty(name = "execution.isolation,strategy", value = "SEMAPHORE")})
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://mircoservice-provider-user/simple/" + id, User.class);
    }

    public User findByIdFallback(Long id) {
        User user = new User();
        user.setId(0L);
        return user;
    }
}
