package com.lb.springboot.dubbo.service.impl;

import com.lb.springboot.dubbo.service.DemoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

/**
 * 功能描述:DemoServiceImpl <br/>
 *
 * @author yunnasheng
 * @date: 2020-12-30 13:50<br/>
 * @since JDK 1.8
 */
@DubboService(version = "1.0")
public class DemoServiceImpl implements DemoService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHi(String name) {
        return String.format("[%s]: Hi, %s",serviceName,name);
    }
}
