package com.sunny.cloud.feign;

import com.sunny.cloud.entity.User;
import com.sunny.config.FeignConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "mircoservice-provider-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {

    // 两个坑：1. @GetMapping不支持   2. @PathVariable得设置value
    @RequestLine("GET /simple/{id}")
    public User findById(@Param("id") Long id);

}
