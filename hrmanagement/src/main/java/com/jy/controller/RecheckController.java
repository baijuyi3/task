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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/10/20.
 */
@Controller
public class RecheckController {
    @Autowired
    private AdminService adminService;

    private SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");

    //    *******************************招聘信息***************************************

    @RequestMapping("/recheck")//查询
    public String recheck(Model model)throws Exception{
        List<Check> checks=adminService.getCheckByState(1);
        model.addAttribute("checks",checks);
        return "admin_view/recheck";
    }

    //*************同意与否************
    @RequestMapping("/recheck_s")
    public String recheck_s(int state,int id,Model model)throws Exception{
        Check check=adminService.getCheckById(id);
        check.setState(state);
        adminService.updateCheck(check);
        if(state==2){
            Date date=new Date();
            Reward reward=adminService.getRewardById(check.getR_id());
            reward.setMoney(-reward.getMoney());
            reward.setReason(check.getReason());
            reward.setDate(df.format(date));
            adminService.saveReward(reward);
        }
        return recheck(model);
    }
}
