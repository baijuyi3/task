package com.jy.controller;


import com.jy.model.*;
import com.jy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/10/20.
 */
@Controller
public class AccountController {
    @Autowired
    private AdminService adminService;

    private SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat df1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat df2=new SimpleDateFormat("yyyy-MM");
    private String mo=" 09:00:00";
    private String af=" 18:00:00";
    //    *******************************薪资结算***************************************

    @RequestMapping("/account")
    public String account(Model model)throws Exception{
        return "admin_view/account";
    }

    @RequestMapping("/salary_account")//结算
    public String salary_account(Model model)throws Exception{
        //日期判断
        Calendar c=Calendar.getInstance();
        if(c.get(Calendar.DAY_OF_MONTH)<15){
            model.addAttribute("msg","未到结算时间");
            return "admin_view/account";
        }
        //已结算判断
        c.add(Calendar.MONTH,-1);
        String time=df2.format(c.getTime());
        List<Salary> salaries=adminService.getSalaryByTime(time);//获取上月的薪水表
        if(salaries.size()>0){
            model.addAttribute("msg","上月已结算");
            return "admin_view/account";
        }
        List<Employee> employees=adminService.getAllEmployee();
        for(Employee e:employees){
            Salary salary=new Salary();
            //打卡判断
            List<Attend> attends=adminService.getAttendsByEidAndMM(e.getId(),time);//获取上月的打卡表
            int i=0;//工作天数
            int j=0;//加班天数
            int k=0;//是否全勤
            for(Attend a:attends){
                i++;
                Date date1=a.getMorning();
                String date=df.format(date1);
                Reward reward=new Reward();
                if(a.getAfternoon()==null){
                    if(i<=22){
                        k++;
                        reward.setReason("旷工");
                        reward.setMoney(-e.getSalary()/22.0);
                        reward.setE_id(e.getId());
                        reward.setDate(date);
                        adminService.saveReward(reward);
                    }
                    continue;
                }
                Date date2=a.getAfternoon();
                Date date_mo=df1.parse((date+mo));
                Date date_af=df1.parse((date+af));
                long t1=date_mo.getTime()-date1.getTime();//迟到毫秒数
                long t2=date2.getTime()-date_af.getTime();//早退毫秒数
                long hour3=3*60*60*1000;

                if(i<=22){
                    if(t1<0L&&t2<0L){
                        //判断是否旷工
                       if(t1+t2+hour3<=0L){
                           k++;
                           reward.setReason("旷工");
                           reward.setMoney(-e.getSalary()/22.0);
                           reward.setE_id(e.getId());
                           reward.setDate(date);
                           adminService.saveReward(reward);
                       }
                       //判断是否迟早早退
                       else {
                           k++;
                           reward.setReason("迟早早退");
                           reward.setMoney(-50);
                           reward.setE_id(e.getId());
                           reward.setDate(date);
                           adminService.saveReward(reward);
                       }
                    }
                }
                else {
                    if(t1<0L&&t2<0L) {
                        //判断加班是否旷工
                        if (t1 + t2 + hour3 <= 0L) {
                            continue;
                        }
                    }
                    j++;
                }
            }
//            *******************打卡判断完后薪资结算***********************
            System.out.println("i:"+i);
            salary.setE_id(e.getId());
            //基本薪资
            if(i<=22){
                salary.setBase(e.getSalary()/22*i);
            }else{
                salary.setBase(e.getSalary());
            }
            if(k==0&&i>=22){
                salary.setBonus(500);
            }else{
                salary.setBonus(0);
            }
            //
            salary.setExtra(e.getSalary()/22.0*j);
            List<Reward> rewards=adminService.getRewardByEidAndTime(e.getId(),time);
            double reward=0.0;
            for(Reward r:rewards){
                reward=reward+r.getMoney();
            }
            salary.setReward(reward);
            double safe=(salary.getBase()+salary.getBonus()+salary.getReward())*0.05;
            salary.setSafe(-safe);
            salary.setTotal(salary.getBase()+salary.getBonus()+salary.getReward()+salary.getSafe());
            salary.setDate(time);
            System.out.println(salary);
            adminService.saveSalary(salary);
        }

        return "admin_view/account";
    }

//    **************************************员工查询*****************************
    @RequestMapping("/salary")//查询
    public String salary(Model model,HttpSession session)throws Exception{
        Calendar c=Calendar.getInstance();
        c.add(Calendar.MONTH,-1);
        String time=df2.format(c.getTime());
        Employee employee= (Employee) session.getAttribute("employee");
        Salary salary=adminService.getSalaryByEidAndTime(employee.getId(),time);
        model.addAttribute("salary",salary);
        return "emp_view/salary";
    }
}
