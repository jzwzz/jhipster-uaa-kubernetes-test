package com.hpe.hpdev.service;

import com.hpe.hpdev.client.AuthorizedUserFeignClient;
import com.hpe.hpdev.web.rest.vm.LoggerVM;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AuthorizedUserFeignClient(name = "svcb")
public interface SvcBAuthorizedUserFeignClient {
    @RequestMapping(value = "/svcb/demo/logs")
    List<LoggerVM> getList();
}
