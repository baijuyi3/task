package com.jy;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/10/19.
 */
@EnableAutoConfiguration
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "123456";
    }
}
