package com.sunny.cloud.feign;

import com.sunny.cloud.entity.User;
import com.sunny.cloud.hystrix.HystrixClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "mircoservice-provider-user", fallback = HystrixClientFallback.class)
public interface UserFeignClient {

    // 两个坑：1. @GetMapping不支持   2. @PathVariable得设置value
    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);

}
