package com.hpe.hpdev.web.rest;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import com.codahale.metrics.annotation.Timed;
import com.hpe.hpdev.service.SvcBAuthorizedFeignClient;
import com.hpe.hpdev.service.SvcBAuthorizedUserFeignClient;
import com.hpe.hpdev.web.rest.vm.LoggerVM;
import feign.RequestInterceptor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//import com.hpe.hpdev.service.SvcBFeignClient;

/**
 * Controller for view and managing Log Level at runtime.
 */
@RestController
@RequestMapping("/api")
public class Demo2Resource {

    @Autowired
    private SvcBAuthorizedFeignClient svcBAuthorizedFeignClient;

    @GetMapping("/demo/logs/authorizedFeignClient")
    @Timed
    public List<LoggerVM> getListAuthorizedFeignClientNoAuth() {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("username = " + username);

        List l = svcBAuthorizedFeignClient.getList();
        System.out.println("svcBAuthorizedFeignClient.size() = " + l.size());

        return context.getLoggerList()
            .stream()
            .map(LoggerVM::new)
            .collect(Collectors.toList());
    }

}
