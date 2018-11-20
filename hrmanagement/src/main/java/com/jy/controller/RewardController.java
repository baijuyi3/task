package com.jy.controller;


import com.jy.model.Department;
import com.jy.model.Reward;
import com.jy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/10/20.
 */
@Controller
public class RewardController {
    @Autowired
    private AdminService adminService;

    //    *******************************招聘信息***************************************

    @RequestMapping("/reward")//查询
    public String reward(Model model)throws Exception{
        List<Reward> rewards=adminService.getAllReward();
        model.addAttribute("rewards",rewards);
        return "admin_view/reward";
    }

    //*************新建************
    @RequestMapping("/reward_save")
    public String reward_save(Model model)throws Exception{
        model.addAttribute("reward_s",true);
        return "admin_view/reward";
    }

    @RequestMapping("/save_reward")
    public String save_reward(Reward reward,Model model)throws Exception{
        boolean res=adminService.saveReward(reward);
        if(!res){
            model.addAttribute("msg","存入失败");
        }
        return reward(model);
    }

    //*************更新************
    @RequestMapping("/reward_update")
    public String reward_update(int id,Model model,HttpSession session)throws Exception{
        Reward reward =adminService.getRewardById(id);
        model.addAttribute("reward_u",reward);
        model.addAttribute("r_id",id);
        return "admin_view/reward";
    }

    @RequestMapping("/update_reward")
    public String update_reward(Reward reward,Model model,HttpSession session)throws Exception{
        System.out.println(reward);
        boolean res=adminService.updateReward(reward);
        if(!res){
            model.addAttribute("msg","更新失败");
        }
        return reward(model);
    }

}
