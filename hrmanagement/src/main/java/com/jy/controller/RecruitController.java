package com.jy.controller;

import com.jy.model.Recruit;
import com.jy.model.Resume;
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
public class RecruitController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

//    *******************************招聘信息***************************************

    @RequestMapping("/recruit")//查询
    public String recruit(Model model)throws Exception{
       List<Recruit> recruits=adminService.getRecruits();
       model.addAttribute("recruits",recruits);
        return "admin_view/recruit";
    }

    @RequestMapping("/recruit_info")//查询
    public String recruit_info(int id,Model model)throws Exception{
        Recruit recruit=adminService.getRecruitById(id);
        model.addAttribute("recruit_info",recruit);
        return "admin_view/recruit";
    }

    //*************新建************
    @RequestMapping("/recruit_save")
    public String recruit_save(Recruit recruit,Model model)throws Exception{
        model.addAttribute("recruit_s",true);
        return "admin_view/recruit";
    }

    @RequestMapping("/save_recruit")
    public String save_recruit(Recruit recruit,Model model)throws Exception{
       boolean res=adminService.saveRecruit(recruit);
       if(!res){
           model.addAttribute("msg","存入失败");
       }
        return recruit(model);
    }

    //*************更新************
    @RequestMapping("/recruit_update")
    public String recruit_update(int id,Model model,HttpSession session)throws Exception{
        Recruit recruit=adminService.getRecruitById(id);
        model.addAttribute("recruit_u",recruit);
        return "admin_view/recruit";
    }

    @RequestMapping("/update_recruit")
    public String update_recruit(Recruit recruit,Model model,HttpSession session)throws Exception{
        boolean res=adminService.updateRecruit(recruit);
        if(!res){
            model.addAttribute("msg","更新失败");
        }
        return recruit(model);
    }
    //*************删除************
    @RequestMapping("/recruit_del")
    public String  del_resume(int id,Model model,HttpSession session)throws Exception{
        boolean res=adminService.delRecruit(id);
        if(!res){
            model.addAttribute("msg","删除失败");
        }else {
            model.addAttribute("msg","删除成功");
        }
       return recruit(model);
    }
}
