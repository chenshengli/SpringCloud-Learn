package com.sunny.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sunny.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id}")
    //添加注解实现熔断的回调方法
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://mircoservice-provider-user/simple/" + id, User.class);
    }

    public User findByIdFallback(Long id) {
        User user = new User();
        user.setId(0L);
        return user;
    }
}
