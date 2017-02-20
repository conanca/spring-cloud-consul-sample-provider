package org.springframework.cloud.consul.sample.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by conanca on 17-2-15.
 */
@RefreshScope
@RestController
public class HelloController {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public String sayHello(@PathVariable(value = "name") String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping("hello2")
    public String sayHello2() {
        long start = System.currentTimeMillis();
        // 随机睡眠1000毫秒以内
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long cost = System.currentTimeMillis() - start;
        return "Hello~ " + ", spent " + cost;
    }
}
