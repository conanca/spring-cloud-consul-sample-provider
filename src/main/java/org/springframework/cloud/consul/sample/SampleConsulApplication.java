package org.springframework.cloud.consul.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author Spencer Gibb
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SampleConsulApplication /*implements ApplicationListener<SimpleRemoteEvent>*/ {


    public static void main(String[] args) {
        SpringApplication.run(SampleConsulApplication.class, args);
    }

}
