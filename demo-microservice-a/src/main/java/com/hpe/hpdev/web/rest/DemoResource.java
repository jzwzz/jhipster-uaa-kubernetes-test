package com.hpe.hpdev.web.rest;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import com.codahale.metrics.annotation.Timed;
import com.hpe.hpdev.service.SvcBAuthorizedFeignClient;
import com.hpe.hpdev.service.SvcBAuthorizedUserFeignClient;
//import com.hpe.hpdev.service.SvcBFeignClient;
import com.hpe.hpdev.web.rest.vm.LoggerVM;
import feign.RequestInterceptor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller for view and managing Log Level at runtime.
 */
@RestController
@RequestMapping("/api/")
public class DemoResource {

    @Autowired
    private SvcBAuthorizedUserFeignClient svcBAuthorizedUserFeignClient;


//    @Autowired
//    @Qualifier("")
//    private  RestTemplate restTemplate;

    @GetMapping("/demo/logs/authorizedUserFeignClient")
    @Timed
    public List<LoggerVM> getListAuthorizedUserFeignClient() {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();


        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("username = " + username);


        String result = ToStringBuilder.reflectionToString(svcBAuthorizedUserFeignClient);
        System.out.println("svcBAuthorizedUserFeignClient = " + result);

        List l = svcBAuthorizedUserFeignClient.getList();
        System.out.println("svcBAuthorizedUserFeignClient.size() = " + l.size());


        return context.getLoggerList()
            .stream()
            .map(LoggerVM::new)
            .collect(Collectors.toList());
    }
}
