package com.jy.controller;

import com.jy.model.Deliver;
import com.jy.model.Department;
import com.jy.model.Position;
import com.jy.model.Resume;
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
public class EmployeeController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    //    *******************************招聘信息***************************************

    @RequestMapping("/save_employee")//查询
    public String save_employee(int id,Model model)throws Exception{
        Deliver deliver=adminService.getDeliverById(id);
        Resume resume=userService.getResumeById(deliver.getR_id());
        List<Department> departments=adminService.getAllDepartment();
        List<Position> positions=adminService.getAllPosition();
        model.addAttribute("deliver",deliver);
        model.addAttribute("resume",resume);
        model.addAttribute("departments",departments);
        model.addAttribute("positions",positions);
        return "admin_view/deliver_3";
    }
}
