package com.sunny.cloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.sunny.cloud.entity.User;
import com.sunny.cloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id) {
        return this.userRepository.getOne(id);
    }

    @PostMapping("/postUser")
    public User postUser(@RequestBody User user) {
        return user;
    }

    @GetMapping("/getUser")
    public User getUser(User user) {
        return user;
    }

    /**
     * 根据虚拟实力名称，获取ip及端口地址
     * @return
     */
    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("MIRCOSERVICE-PROVIDER-USER", false);
        return instance.getHomePageUrl();
    }

    /**
     * 获取实例信息，包括虚拟实例名称等
     * @return
     */
    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }
}
