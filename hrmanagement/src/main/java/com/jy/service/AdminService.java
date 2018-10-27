package com.jy.service;

import com.jy.model.*;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24.
 */
public interface AdminService {
    //    *********面试流程**********
    boolean updateDeliver(Deliver deliver);
    List<Deliver> getDeliverByState(int state);
    Deliver getDeliverById(int id);
    //    *********招聘信息**********
    boolean saveRecruit(Recruit recruit);
    boolean delRecruit(int id);
    boolean updateRecruit(Recruit recruit);
    List<Recruit> getRecruits();
    Recruit getRecruitById(int id);
    //    *********部门*********
    boolean saveDepartment(Department department);
    boolean delDepartment(int id);
    boolean updateDepartment(Department department);
    List<Department> getAllDepartment();
    Department getDepartmentById(int id);
    Department getDepartmentByName(String name);
    //    *********职位**********
    boolean savePosition(Position position);
    boolean delPosition(int id);
    boolean updatePosition(Position position);
    List<Position> getAllPosition();
    Position getPositionById(int id);
    Position getPositionByName(String name);
    //    *********员工**********
    boolean saveEmployee(Employee employee);
    boolean delEmployee(int id);
    boolean updateEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(int id);
    Employee getEmployeeByUser(String user);
    Employee getEmployeeByUid(int uid);
}
