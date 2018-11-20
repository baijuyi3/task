package com.jy.controller;

import com.jy.model.Department;
import com.jy.model.Employee;
import com.jy.model.Position;
import com.jy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2018/10/20.
 */
@Controller
public class QuitController {
    @Autowired
    private AdminService adminService;

    //3级联动员工信息
    @RequestMapping("/quit_e")//面试通过
    public String quit_e(Model model)throws Exception{
        return "emp_view/quit";
    }
    //---------------------------------
    @RequestMapping("/quit")
    public String quit(int id,Model model)throws Exception{
        Employee employee=adminService.getEmployeeById(id);
        employee.setD_id(0);
        employee.setP_id(0);
        employee.setState(3);
        adminService.updateEmployee(employee);
        return "emp_view/emp_employee";
    }
}
