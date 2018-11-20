package com.jy.controller;

import com.jy.model.Attend;
import com.jy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2018/10/20.
 */
@Controller
public class AttendController {
    @Autowired
    private EmployeeService employeeService;

    private Format df = new SimpleDateFormat("yyyy-MM-dd");



    @RequestMapping("/attend")
    public String attend(Model model)throws Exception{
        return "emp_view/attend";
    }

//    ********************************登入注册****************************************
    @RequestMapping("/attend_card")
    public String attend_card(int e_id,HttpSession session, Model model)throws Exception{
        Date date=new Date();
        Attend attend=employeeService.getAttendsByEidAndDD(e_id,df.format(date));
        if(attend==null){
            boolean res=employeeService.saveAttend(e_id);
        }else{
            attend.setAfternoon(date);
            boolean res=employeeService.updateAttend(attend);
        }
        return "emp_view/attend";
    }
}
