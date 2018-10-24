package com.jy.controller;

import com.jy.model.Deliver;
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
public class DeliverController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    //  *********************************申请**************************************
    @RequestMapping("/save_deliver")
    public String save_deliver(Deliver deliver,Model model, HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        deliver.setU_id(user.getU_id());
        deliver.setState(1);
        boolean res=userService.saveDeliver(deliver);
        if(res){
            model.addAttribute("msg","投递成功！");
        }else {
            model.addAttribute("msg","投递失败！");
        }
        return  "view";
    }
    @RequestMapping("/resume_choose")
    public String resume_choose(int rc_id,int rc_name, Model model, HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        Deliver deliver=userService.getDeliverByUidAndRcid(user.getU_id(),rc_id);
        System.out.println(deliver);
        if(deliver!=null){
            model.addAttribute("msg","不能重复投递！");
            return  "view";
        }
        model.addAttribute("rc_id",rc_id);
        model.addAttribute("rc_name",rc_name);
        List<Resume> resumes=userService.getResumeByUid(user.getU_id());
        model.addAttribute("resumes",resumes);
        return "resume_choose";
    }

    //  *********************************查看简历**************************************
    @RequestMapping("/deliver_info")
    public String deliver_info(int id,Model model, HttpSession session)throws Exception{
        Deliver deliver=adminService.getDeliverById(id);
        Resume resume=userService.getResumeById(deliver.getR_id());
        model.addAttribute("resume",resume);
        model.addAttribute("d_id",id);
        return "deliver_info";
    }

    @RequestMapping("/deliver_2")
    public String deliver_2(int id,Model model, HttpSession session)throws Exception{
        Deliver deliver=adminService.getDeliverById(id);
        deliver.setState(2);
        boolean res=adminService.updateDeliver(deliver);
       if(!res){
           model.addAttribute("msg","同意失败");
       }
        List<Deliver> deliver_1=userService.getDeliverByState(1);
        session.setAttribute("deliver_1",deliver_1);
        return "admin_view";
    }
    @RequestMapping("/deliver_0")
    public String deliver_0(int id,Model model, HttpSession session)throws Exception{
        Deliver deliver=adminService.getDeliverById(id);
        deliver.setState(0);
        boolean res=adminService.updateDeliver(deliver);
        if(!res){
            model.addAttribute("msg","拒绝失败");
        }
        List<Deliver> deliver_1=userService.getDeliverByState(1);
        session.setAttribute("deliver_1",deliver_1);
        return "admin_view";
    }
}
