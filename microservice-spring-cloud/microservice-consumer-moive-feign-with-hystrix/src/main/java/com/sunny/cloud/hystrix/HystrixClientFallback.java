package com.sunny.cloud.hystrix;

import com.sunny.cloud.entity.User;
import com.sunny.cloud.feign.UserFeignClient;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements UserFeignClient {

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(0L);
        return user;
    }
}
