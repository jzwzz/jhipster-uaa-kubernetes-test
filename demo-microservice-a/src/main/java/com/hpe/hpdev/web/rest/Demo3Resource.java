package com.hpe.hpdev.web.rest;

import ch.qos.logback.classic.LoggerContext;
import com.codahale.metrics.annotation.Timed;
import com.hpe.hpdev.service.SvcBAuthorizedFeignClient;
import com.hpe.hpdev.web.rest.vm.LoggerVM;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

//import com.hpe.hpdev.service.SvcBFeignClient;

/**
 * Controller for view and managing Log Level at runtime.
 */
@RestController
@RequestMapping("/demo3")
public class Demo3Resource {

    @Autowired
    private SvcBAuthorizedFeignClient svcBAuthorizedFeignClient;

    @GetMapping("/hello")
    @Timed
    public String hello() {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("username = " + username);

//        List l = svcBAuthorizedFeignClient.getList();
//        System.out.println("svcBAuthorizedFeignClient.size() = " + l.size());

        return username;
    }

}
