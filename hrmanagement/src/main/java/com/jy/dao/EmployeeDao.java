package com.jy.dao;

import com.jy.model.Employee;

import java.util.List;

/**
 * Created by Administrator on 2018/10/26.
 */
public interface EmployeeDao {
    int saveEmployee(Employee employee);
    int delEmployee(int id);
    int updateEmployee(Employee employee);
    List<Employee> getAllEmployee();
    List<Employee> getEmployeeByDid(int did);
    Employee getEmployeeById(int id);
    Employee getEmployeeByUser(String user);
    Employee getEmployeeByUid(int uid);
}
