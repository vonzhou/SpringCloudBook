package com.didispace.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String index() {
        ServiceInstance serviceInstance = client.getLocalServiceInstance();
        logger.info(String.format("/hello, host : %s, service_id : %s", serviceInstance.getHost(), serviceInstance.getServiceId()));
        return "Hello World";
    }

}