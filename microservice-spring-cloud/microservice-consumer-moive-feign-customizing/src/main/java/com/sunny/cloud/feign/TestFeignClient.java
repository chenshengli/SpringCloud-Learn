package com.sunny.cloud.feign;

import com.sunny.config.AuthorizedConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//此注解可以添加url，并且一定需要声明name，但是一旦添加url则name属性仅仅是一个名称，没有url的情况下是application-id
@FeignClient(name = "xxx", url = "http://localhost:8761/", configuration = AuthorizedConfiguration.class)
public interface TestFeignClient {

    @RequestMapping(value = "/eureka/apps/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName")String serviceName);
}
