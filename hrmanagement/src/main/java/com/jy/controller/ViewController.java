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
public class ViewController {
    @Autowired
    private UserService userService;

    @RequestMapping("/view")
    public String view(Model model){

        return "view";
    }

    @RequestMapping("/")
    public String loginView(Model model){

        return "../../login";
    }

//    ********************************登入注册****************************************
    @RequestMapping("/login")
    public String login(User user, HttpSession session, Model model)throws Exception{
//        System.out.println(user);
        User user1=userService.getUserByNameAndPass(user);
//        System.out.println(user1);
        if(null!=user1){
            session.setAttribute("user",user1);
            return "view";
        }
        model.addAttribute("msg","用户名或密码错误！");
        return "../../login";
    }

    @RequestMapping("/register")
    public String register(User user,Model model)throws Exception{
        User user1=new User();
//        System.out.println(user);
        user1.setU_name(user.getU_name());
//        System.out.println(user1);
        User user2=userService.getUserByNameAndPass(user1);
//        System.out.println(user2);
        if(user2!=null){
            model.addAttribute("msg","该用户名已存在");
            return "../../register";
        }
        boolean res=userService.addUser(user);
        model.addAttribute("msg",(res?"注册成功":"注册失败"));
        return "../../register";
    }


//    ********************************简历****************************************

    @RequestMapping("/resume")
    public String resume(Model model){

        return "resume";
    }
}
