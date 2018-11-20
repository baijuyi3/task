package com.jy.controller;

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
public class EmpTrainController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/train_e")
    public String train_e(Model model,HttpSession session)throws Exception{
        Employee employee= (Employee) session.getAttribute("employee");
        List<Train> trains=adminService.getAllTrain();
        List<TrainRecord> trainRecords=adminService.getTrainRecordByEid(employee.getId());
        model.addAttribute("trainRecords",trainRecords);
        model.addAttribute("trains",trains);
        return "emp_view/train_e";
    }

//    ********************************登入注册****************************************
    @RequestMapping("/train_e_update")
    public String login(int state,int id,HttpSession session, Model model)throws Exception{
        TrainRecord trainRecord=adminService.getTrainRecordById(id);
        trainRecord.setState(state);
        adminService.updateTrainRecord(trainRecord);
        return train_e(model,session);
    }
}
