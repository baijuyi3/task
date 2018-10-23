package com.jy.controller;

import com.jy.model.User;
import com.jy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2018/10/20.
 */
@Controller
public class AjaxController {
    @Autowired
    private UserService userService;

    @RequestMapping("/check_user")
    public void check_user(String name,Model model,HttpServletResponse resp) throws IOException {
        User user1=new User();
        user1.setU_name(name);
        User user=userService.getUserByNameAndPass(user1);
        if (user!=null){
            resp.getWriter().print("n");
        }
        resp.getWriter().print("y");
    }
}
