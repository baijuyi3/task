package com.jy.dao;

import com.jy.model.Salary;

import java.util.List;

/**
 * Created by Administrator on 2018/11/1.
 */
public interface SalaryDao {
    int saveSalary(Salary salary);
    List<Salary> getSalaryByEid(int eid);
    List<Salary> getSalaryByTime(String  time);
    Salary getSalaryByEidAndTime(int eid ,String time);
}
