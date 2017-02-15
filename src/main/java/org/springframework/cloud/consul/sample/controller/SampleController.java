package org.springframework.cloud.consul.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by conanca on 17-2-14.
 */
@RestController
public class SampleController {
    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name:service-test1}")
    private String appName;

    @RequestMapping("/me")
    public ServiceInstance me() {
        return discoveryClient.getLocalServiceInstance();
    }

    @RequestMapping("/")
    public ServiceInstance lb() {
        return loadBalancer.choose(appName);
    }

    @RequestMapping("/rest")
    public String rest() {
        return this.restTemplate.getForObject("http://" + appName + "/me", String.class);
    }

    @RequestMapping("/choose")
    public String choose() {
        return loadBalancer.choose(appName).getUri().toString();
    }

    @RequestMapping("/myenv")
    public String env(@RequestParam("prop") String prop) {
        return env.getProperty(prop, "Not Found");
    }

    @RequestMapping("/instances")
    public List<ServiceInstance> instances() {
        return discoveryClient.getInstances(appName);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
