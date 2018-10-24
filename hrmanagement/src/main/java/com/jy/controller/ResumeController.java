package com.jy.controller;

import com.jy.model.Resume;
import com.jy.model.User;
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
public class ResumeController {
    @Autowired
    private UserService userService;

//    ********************************简历****************************************

    @RequestMapping("/resume")
    public String resume(Model model,HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        List<Resume> resumes=userService.getResumeByUid(user.getU_id());
        model.addAttribute("resumes",resumes);
        return "resume";
    }

 //*************新建************
    @RequestMapping("/resume_save")
    public String resume_save(Model model)throws Exception{
        return "resume_save";
    }

    @RequestMapping("/new_resume")
    public String new_resume(Resume resume,Model model,HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        resume.setUid(user.getU_id());
//        System.out.println(resume);
        boolean res=userService.saveResume(resume);
        if(!res){
            model.addAttribute("msg","创建失败");
            return "resume_save";
        }
        return resume(model,session);
    }

//*************更新************
    @RequestMapping("/resume_update")
    public String resume_update(int id,Model model)throws Exception{
        Resume resume=userService.getResumeById(id);
        model.addAttribute("resume",resume);
        return "resume_update";
    }

    @RequestMapping("/update_resume")
    public String update_resume(Resume resume,Model model,HttpSession session)throws Exception{
        System.out.println(resume);
        boolean res=userService.updateResume(resume);
        if(!res){
            model.addAttribute("msg","更新失败");
            return "resume_update";
        }
//        model.addAttribute("msg","更新成功");
        return resume(model,session);
    }

    @RequestMapping("/del_resume")
    public String  del_resume(int id,Model model,HttpSession session)throws Exception{
        System.out.println("id:"+id);
        boolean res=userService.delResume(id);
        if(!res){
            model.addAttribute("msg","删除失败");
        }else {
            model.addAttribute("msg","删除成功");
        }
       return resume(model, session);
    }
}
