package com.jy.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/10/19.
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){
        return "../../hello";
    }

    @RequestMapping("/hello2")
    public String hello2(Model model){
        return "ok";
    }
}
