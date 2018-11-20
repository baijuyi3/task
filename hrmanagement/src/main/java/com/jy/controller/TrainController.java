package com.jy.controller;


import com.jy.model.Department;
import com.jy.model.Employee;
import com.jy.model.Train;
import com.jy.model.TrainRecord;
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
public class TrainController {
    @Autowired
    private AdminService adminService;

    //    *******************************招聘信息***************************************

    @RequestMapping("/train")//查询
    public String train(Model model)throws Exception{
        List<Train> trains=adminService.getAllTrain();
        model.addAttribute("trains",trains);
        return "admin_view/train";
    }

    //*************新建************
    @RequestMapping("/train_save")
    public String train_save(Model model)throws Exception{
        model.addAttribute("train_s",true);
        return "admin_view/train";
    }

    @RequestMapping("/save_train")
    public String save_train(Train train,Model model)throws Exception{
        boolean res=adminService.saveTrain(train);
        if(!res){
            model.addAttribute("msg","存入失败");
        }
        return train(model);
    }

    //*************更新************
    @RequestMapping("/train_update")
    public String train_update(int id,Model model,HttpSession session)throws Exception{
        Train train=adminService.getTrainById(id);
        model.addAttribute("train_u",train);
        return "admin_view/train";
    }

    @RequestMapping("/update_train")
    public String update_train(Train train,Model model,HttpSession session)throws Exception{
        boolean res=adminService.updateTrain(train);
        if(!res){
            model.addAttribute("msg","更新失败");
        }
        return train(model);
    }
    //*************删除************
    @RequestMapping("/train_del")
    public String  del_train(int id,Model model,HttpSession session)throws Exception{
        boolean res=adminService.delTrain(id);
        if(!res){
            model.addAttribute("msg","删除失败");
        }else {
            model.addAttribute("msg","删除成功");
        }
        return train(model);
    }
    //----------------详细信息-----------------
    @RequestMapping("/train_info")
    public String train_info(int id,Model model)throws Exception{
       Train train=adminService.getTrainById(id);
       model.addAttribute("train_info",train);
        return "admin_view/train";
    }

    //----------------发送-----------------
    @RequestMapping("/train_send")
    public String train_send(int id,Model model)throws Exception{
        model.addAttribute("train_id",id);
        return "admin_view/train";
    }

    @RequestMapping("/train_dep")
    public String train_dep(int id,Model model)throws Exception{
        List<Department> departments=adminService.getAllDepartment();
        model.addAttribute("send_departments",departments);
        model.addAttribute("t_id",id);
        return "admin_view/train";
    }
    @RequestMapping("/train_emp")
    public String train_emp(int id,Model model)throws Exception{
        List<Employee> employees=adminService.getAllEmployee();
        model.addAttribute("send_emps",employees);
        model.addAttribute("t_id",id);
        return "admin_view/train";
    }

    @RequestMapping("/send_d")
    public String send_d(int t_id,String dep,Model model)throws Exception{
        Department department=adminService.getDepartmentByName(dep);
        List<Employee> employees=adminService.getEmployeeByDid(department.getId());
        TrainRecord trainRecord=new TrainRecord();
        trainRecord.setT_id(t_id);
        trainRecord.setState(1);
        for (int i = 0; i <employees.size() ; i++) {
            trainRecord.setE_id(employees.get(i).getId());
            boolean res=adminService.saveTrainRecord(trainRecord);
        }
        return train(model);
    }

    @RequestMapping("/send_e")
    public String send_e(int t_id,String emp_ids,Model model)throws Exception{
        TrainRecord trainRecord=new TrainRecord();
        trainRecord.setT_id(t_id);
        trainRecord.setState(1);
        String ids[]=emp_ids.split(",");
        for (int i = 0; i <ids.length ; i++) {
            Employee employee=adminService.getEmployeeById(Integer.parseInt(ids[i]));
            trainRecord.setE_id(employee.getId());
            boolean res=adminService.saveTrainRecord(trainRecord);
        }
        return train(model);
    }

}
