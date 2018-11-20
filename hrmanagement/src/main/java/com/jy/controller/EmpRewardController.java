package com.jy.controller;


import com.jy.model.Check;
import com.jy.model.Employee;
import com.jy.model.Reward;
import com.jy.service.AdminService;
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
public class EmpRewardController {
    @Autowired
    private AdminService adminService;

    //    *******************************招聘信息***************************************

    @RequestMapping("/reward_e")//查询
    public String reward_e(Model model,HttpSession session)throws Exception{
        Employee employee= (Employee) session.getAttribute("employee");
        List<Reward> rewards=adminService.getRewardByEid(employee.getId());
        model.addAttribute("rewards",rewards);
        return "emp_view/reward_e";
    }

    //*************新建************
    @RequestMapping("/recheck_e")
    public String recheck_e(int id,Model model)throws Exception{
        Reward reward=adminService.getRewardById(id);
        model.addAttribute("recheck",reward);
        return "emp_view/reward_e";
    }

    @RequestMapping("/recheck_save")
    public String recheck_save(Check check, Model model,HttpSession session)throws Exception{
        adminService.saveCheck(check);
        return reward_e(model, session);
    }
}
