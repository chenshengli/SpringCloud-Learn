package com.sunny.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class PreZuulFilter extends ZuulFilter {

    private static final Logger LOGGER =  LoggerFactory.getLogger(PreZuulFilter.class);

    @Override
    public String filterType() {
        return "pre"; // 有4个不同的type：pre、routing、post、error
    }

    @Override
    public int filterOrder() {
        return 1; // 执行filter的顺序越大越靠后
    }

    @Override
    public boolean shouldFilter() {
        return true; // 这个filter是否可用
    }

    @Override
    public Object run() { // 实现的方法
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String host = request.getRemoteHost();
        PreZuulFilter.LOGGER.info("请求的host:{}", host);
        return null;
    }
}
