package com.didispace.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    /**
     * 具体看 ZoneAwareLoadBalancer
     */
    @LoadBalanced
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer1", method = RequestMethod.GET)
    public String helloConsumer1() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    }


    @RequestMapping(value = "/ribbon-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        return helloService.hello2();
    }

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }

}