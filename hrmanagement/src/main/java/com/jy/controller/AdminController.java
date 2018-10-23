package com.jy.controller;

import com.jy.model.User;
import com.jy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/10/20.
 */
@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @RequestMapping("/save_resume")
    public String save_resume(Model model){

        return "resume_save";
    }
}
