package com.jy.controller;

import com.jy.model.*;
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

    //  *********************************user申请**************************************
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
    public String resume_choose(int rc_id,String  rc_name, Model model, HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        if(user==null){
            return "../../login";
        }
        Deliver deliver=userService.getDeliverByUidAndRcid(user.getU_id(),rc_id);
        System.out.println(deliver);
        if(deliver!=null){
            model.addAttribute("msg","不能重复投递！");
            return  "view";
        }
        model.addAttribute("rc_id",rc_id);
        model.addAttribute("rc_name",rc_name);
        List<Resume> resumes=userService.getResumeByUid(user.getU_id());
        if(resumes.size()==0){
            return "resume";
        }
        model.addAttribute("resumes",resumes);
        return "resume_choose";
    }

    //  *********************************admin查看简历**************************************
    @RequestMapping("/deliver_info")
    public String deliver_info(int id,Model model, HttpSession session)throws Exception{
        Deliver deliver=adminService.getDeliverById(id);
        Resume resume=userService.getResumeById(deliver.getR_id());
        model.addAttribute("resume",resume);
        model.addAttribute("d_id",id);
        return "deliver_info";
    }
    @RequestMapping("/deliver_1")
    public String deliver_1(Model model, HttpSession session)throws Exception{
        List<Deliver> deliver_1=userService.getDeliverByState(1);
        model.addAttribute("deliver_1",deliver_1);
        return "admin_view/deliver_1";
    }

    @RequestMapping("/deliver_2")
    public String deliver_2(int id,String interv_date,String place,Model model, HttpSession session)throws Exception{
        Deliver deliver=adminService.getDeliverById(id);
        deliver.setInterv_date(interv_date);
        deliver.setPlace(place);
        deliver.setState(2);
        boolean res=adminService.updateDeliver(deliver);
       if(!res){
           model.addAttribute("msg","同意失败");
       }
        List<Deliver> deliver_1=userService.getDeliverByState(1);
        model.addAttribute("deliver_1",deliver_1);
        return "admin_view/deliver_1";
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
        model.addAttribute("deliver_1",deliver_1);
        return "admin_view/deliver_1";
    }

    //*************************收到信息***********************************
    //面试详细
    @RequestMapping("/offer")
    public String offer(int id,Model model, HttpSession session)throws Exception{
        Deliver deliver=adminService.getDeliverById(id);
        Employee employee=adminService.getEmployeeByUid(deliver.getU_id());
        model.addAttribute("employee",employee);
        return "receive";
    }
    //    面试邀请
    @RequestMapping("/receive")
    public String receive(Model model,HttpSession session){
        User user= (User) session.getAttribute("user");
        List<Deliver> deliver_2=userService.getDeliverByUidAndState(user.getU_id(),2);
        List<Deliver> deliver_4=userService.getDeliverByUidAndState(user.getU_id(),4);
        model.addAttribute("deliver_4",deliver_4);
        model.addAttribute("deliver_2",deliver_2);
        return "receive";
    }

    //面试详细
    @RequestMapping("/interview")
    public String interview(int id,Model model, HttpSession session)throws Exception{
        Deliver deliver=adminService.getDeliverById(id);
        model.addAttribute("deliver2",deliver);
        return "receive";
    }

    //面试同意
    @RequestMapping("/deliverto3")
    public String deliverto3(int id,Model model, HttpSession session)throws Exception{
        Deliver deliver=adminService.getDeliverById(id);
        deliver.setState(3);
        boolean res=adminService.updateDeliver(deliver);
        if(!res){
            model.addAttribute("msg","同意失败");
        }
        User user= (User) session.getAttribute("user");
        List<Deliver> deliver_2=userService.getDeliverByUidAndState(user.getU_id(),2);
        model.addAttribute("deliver_2",deliver_2);
        return "receive";
    }

    //面试拒绝
    @RequestMapping("/deliver_5")
    public String deliver_5(int id,Model model, HttpSession session)throws Exception{
        Deliver deliver=adminService.getDeliverById(id);
        deliver.setState(5);
        boolean res=adminService.updateDeliver(deliver);
        if(!res){
            model.addAttribute("msg","拒绝失败");
        }
        User user= (User) session.getAttribute("user");
        List<Deliver> deliver_2=userService.getDeliverByUidAndState(user.getU_id(),2);
        model.addAttribute("deliver_2",deliver_2);
        return "receive";
    }
    //*************************收到信息***********************************
    @RequestMapping("/deliver")
    public String deliver(Model model, HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        List<Deliver> delivers=userService.getDeliverByUid(user.getU_id());
        model.addAttribute("delivers",delivers);
        return "deliver";
    }
}
