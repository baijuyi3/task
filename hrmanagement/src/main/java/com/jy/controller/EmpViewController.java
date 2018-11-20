package com.jy.controller;

import com.jy.model.Employee;
import com.jy.model.Recruit;
import com.jy.model.User;
import com.jy.service.AdminService;
import com.jy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/10/20.
 */
@Controller
public class EmpViewController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/emp_login")
    public String emp_login(Model model)throws Exception{
        return "../../emp_login";
    }

//    ********************************登入注册****************************************
    @RequestMapping("/emp_view")
    public String login(Employee employee,HttpSession session, Model model)throws Exception{
        Employee employee1=adminService.getEmployeeByUser(employee.getUser());
        if(employee1!=null&&employee1.getPass().equals(employee.getPass())){
            session.setAttribute("employee",employee1);
            return "emp_view/emp_view";
        }
        model.addAttribute("msg","用户名或密码错误！");
        return emp_login(model);
    }
}
