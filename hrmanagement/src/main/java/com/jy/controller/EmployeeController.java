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
public class EmployeeController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    //    *******************************招聘信息***************************************

    @RequestMapping("/employee_save")//存入数据库
    public String employee_save(int id,int state,String d_name,String p_name,int salary,Model model)throws Exception{
        Deliver deliver=adminService.getDeliverById(id);
        Resume resume=userService.getResumeById(deliver.getR_id());
        Department department=adminService.getDepartmentByName(d_name);
        Position position=adminService.getPositionByName(p_name);
        Employee employee=new Employee();
        employee.setName(resume.getName());
        employee.setPass(resume.getPhone());
        employee.setSex(resume.getSex());
        employee.setPhone(resume.getPhone());
        employee.setMail(resume.getMail());
        employee.setD_id(department.getId());
        employee.setP_id(position.getId());
        employee.setSalary(salary);
        employee.setState(state);
        employee.setU_id(deliver.getU_id());
        adminService.saveEmployee(employee);
        List<Employee> employees=adminService.getAllEmployee();
        Employee employee1=employees.get(employees.size()-1);
        employee1.setUser((""+employee1.getName()+employee1.getId()));
        adminService.updateEmployee(employee1);
        deliver.setState(4);
        adminService.updateDeliver(deliver);
        return deliver_3(model);
    }

    @RequestMapping("/save_employee")//分配岗位
    public String save_employee(int id,Model model)throws Exception{
        Deliver deliver=adminService.getDeliverById(id);
        List<Department> departments=adminService.getAllDepartment();
        List<Position> positions=adminService.getAllPosition();
        model.addAttribute("deliver",deliver);
        model.addAttribute("departments",departments);
        model.addAttribute("positions",positions);
        return "admin_view/deliver_3";
    }

    @RequestMapping("/deliver_3")//面试通过
    public String deliver_3(Model model)throws Exception{
        List<Department> departments=adminService.getAllDepartment();
        List<Position> positions=adminService.getAllPosition();
        List<Deliver> deliver_3=userService.getDeliverByState(3);
        model.addAttribute("deliver_3",deliver_3);
        model.addAttribute("departments",departments);
        model.addAttribute("positions",positions);
        return "admin_view/deliver_3";
    }
}
