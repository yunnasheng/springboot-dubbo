package com.lb.springboot.dubbo.controller;

import com.lb.springboot.dubbo.service.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述:DemoController <br/>
 *
 * @author yunnasheng
 * @date: 2020-12-30 16:06<br/>
 * @since JDK 1.8
 */
@RestController
public class DemoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @DubboReference(version = "1.0", url = "dubbo://127.0.0.1:20088")
    private DemoService demoService;

    @GetMapping(value = "hi/{name}")
    public String index(@PathVariable(value = "name") String name){
        LOGGER.info("running ...");
        return demoService.sayHi(name);
    }
}
