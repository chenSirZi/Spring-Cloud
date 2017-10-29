package com.example.microserviceorder.controller;

import com.example.microserviceorder.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Bean
    // 未消费者整合ribbon
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    };

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    // microservier 之间直接通过 Rest调用
    @GetMapping("/findUser")
    public User findUser(User user) {
        return this.restTemplate.getForObject("http://user:admin@localhost:8081/findUser",User.class);
    }


    // eureka之间直接通过 Rest调用
    @GetMapping("/user")
    public User user(User user) {
        return this.restTemplate.getForObject("http://MICSERVICE-USER/findUser",User.class);
    }

    // eureka ribbon ip
    @GetMapping("/logUseInstance")
    public void logUseInstance(){
        ServiceInstance serviceInstance=this.loadBalancerClient.choose("micservice-user");
        // 打印本次请求地址
        System.err.println(serviceInstance.getServiceId()+":"+serviceInstance.getHost()+"："+
                serviceInstance.getPort());


    }

}
