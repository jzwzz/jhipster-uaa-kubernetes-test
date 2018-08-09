package com.hpe.hpdev.service;

import com.hpe.hpdev.client.AuthorizedFeignClient;
import com.hpe.hpdev.web.rest.vm.LoggerVM;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AuthorizedFeignClient(name = "svcb")
public interface SvcBAuthorizedFeignClient {
    @RequestMapping(value = "/svcb/demo/logs")
    List<LoggerVM> getList();
}
