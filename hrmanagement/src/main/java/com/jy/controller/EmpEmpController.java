package com.jy.controller;

import com.jy.model.*;
import com.jy.service.AdminService;
import com.jy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2018/10/20.
 */
@Controller
public class EmpEmpController {
    @Autowired
    private AdminService adminService;

    //3级联动员工信息
    @RequestMapping("/employee_e")//面试通过
    public String employee_e(Model model)throws Exception{
        List<Department> departments=adminService.getAllDepartment();
        List<Position> positions=adminService.getAllPosition();
        List<Employee> employees=adminService.getAllEmployee();
        model.addAttribute("departments",departments);
        model.addAttribute("positions",positions);
        model.addAttribute("employees",employees);
        return "emp_view/emp_employee";
    }
    //---------------------------------
    @RequestMapping("/employee_info_e")
    public String employee_info_e(String user,Model model)throws Exception{
        Employee employee=adminService.getEmployeeByUser(user);
        Position position=adminService.getPositionById(employee.getP_id());
        Department department=adminService.getDepartmentById(employee.getD_id());
        model.addAttribute("position",position);
        model.addAttribute("department",department);
        model.addAttribute("employee_info",employee);
        return "emp_view/emp_employee";
    }
}
