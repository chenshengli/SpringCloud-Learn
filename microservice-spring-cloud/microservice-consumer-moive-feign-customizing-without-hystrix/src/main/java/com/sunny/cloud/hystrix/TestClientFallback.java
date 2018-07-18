package com.sunny.cloud.hystrix;

import com.sunny.cloud.feign.TestFeignClient;

public class TestClientFallback implements TestFeignClient {

    @Override
    public String findServiceInfoFromEurekaByServiceName(String serviceName) {
        return "hahaha";
    }
}
