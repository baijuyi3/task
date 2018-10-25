package com.jy.controller;


import com.jy.model.Department;
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
public class DepartmentController {
    @Autowired
    private AdminService adminService;

    //    *******************************招聘信息***************************************

    @RequestMapping("/department")//查询
    public String department(Model model)throws Exception{
        List<Department> departments=adminService.getAllDepartment();
        model.addAttribute("departments",departments);
        return "admin_view/department";
    }

    //*************新建************
    @RequestMapping("/department_save")
    public String department_save(Department department,Model model)throws Exception{
        model.addAttribute("department_s",true);
        return "admin_view/department";
    }

    @RequestMapping("/save_department")
    public String save_department(Department department,Model model)throws Exception{
        boolean res=adminService.saveDepartment(department);
        if(!res){
            model.addAttribute("msg","存入失败");
        }
        return department(model);
    }

    //*************更新************
    @RequestMapping("/department_update")
    public String department_update(int id,Model model,HttpSession session)throws Exception{
        Department department=adminService.getDepartmentById(id);
        model.addAttribute("department_u",department);
        return "admin_view/department";
    }

    @RequestMapping("/update_department")
    public String update_department(Department department,Model model,HttpSession session)throws Exception{
        boolean res=adminService.updateDepartment(department);
        if(!res){
            model.addAttribute("msg","更新失败");
        }
        return department(model);
    }
    //*************删除************
    @RequestMapping("/department_del")
    public String  del_department(int id,Model model,HttpSession session)throws Exception{
        boolean res=adminService.delDepartment(id);
        if(!res){
            model.addAttribute("msg","删除失败");
        }else {
            model.addAttribute("msg","删除成功");
        }
        return department(model);
    }

}
