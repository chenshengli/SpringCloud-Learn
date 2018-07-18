package com.sunny.cloud.controller;

import com.sunny.cloud.entity.User;
import com.sunny.cloud.feign.TestFeignClient;
import com.sunny.cloud.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private TestFeignClient testFeignClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }

    @GetMapping("/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName) {
        return this.testFeignClient.findServiceInfoFromEurekaByServiceName(serviceName);
    }
}
