package com.jy.service.impl;

import com.jy.dao.*;
import com.jy.model.*;
import com.jy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private RecruitDao recruitDao;
    @Autowired
    private DeliverDao deliverDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private PositionDao positionDao;
    @Autowired
    private EmployeeDao employeeDao;
//    ****************************面试流程**********************
    @Override
    public boolean updateDeliver(Deliver deliver) {
        if(deliver==null){
            return false;
        }
        int row=deliverDao.updateDeliver(deliver);
        return true;
    }

    @Override
    public List<Deliver> getDeliverByState(int state) {
        return deliverDao.getDeliverByState(state);
    }

    @Override
    public Deliver getDeliverById(int id) {
        return deliverDao.getDeliverById(id);
    }

    //    *****************************招聘信息**********
    @Override
    public boolean saveRecruit(Recruit recruit) {
        int row=recruitDao.saveRecruit(recruit);
        return true;
    }

    @Override
    public boolean delRecruit(int id) {
        int row=recruitDao.delRecruit(id);
        return true;
    }

    @Override
    public boolean updateRecruit(Recruit recruit) {
        int row=recruitDao.updateRecruit(recruit);
        return true;
    }

    @Override
    public List<Recruit> getRecruits() {
        return recruitDao.getRecruits();
    }

    @Override
    public Recruit getRecruitById(int id) {
        return recruitDao.getRecruitById(id);
    }

    //    ***************************部门***************************
    @Override
    public boolean saveDepartment(Department department) {
        int row = departmentDao.saveDepartment(department);
        return true;
    }

    @Override
    public boolean delDepartment(int id) {
        int row = departmentDao.delDepartment(id);
        return true;
    }

    @Override
    public boolean updateDepartment(Department department) {
        int row = departmentDao.updateDepartment(department);
        return true;
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentDao.getAllDepartment();
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentDao.getDepartmentById(id);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentDao.getDepartmentByName(name);
    }

    //    **************************职位*********************************
    @Override
    public boolean savePosition(Position position) {
        int row=positionDao.savePosition(position);
        return true;
    }

    @Override
    public boolean delPosition(int id) {
        int row=positionDao.delPosition(id);
        return true;
    }

    @Override
    public boolean updatePosition(Position position) {
        int row=positionDao.updatePosition(position);
        return true;
    }

    @Override
    public List<Position> getAllPosition() {
        return positionDao.getAllPosition();
    }

    @Override
    public Position getPositionById(int id) {
        return positionDao.getPositionById(id);
    }

    @Override
    public Position getPositionByName(String name) {
        return positionDao.getPositionByName(name);
    }

    //    ****************************员工*****************************
    @Override
    public boolean saveEmployee(Employee employee) {
        int row=employeeDao.saveEmployee(employee);
        return true;
    }

    @Override
    public boolean delEmployee(int id) {
        int row=employeeDao.delEmployee(id);
        return true;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        int row=employeeDao.updateEmployee(employee);
        return true;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public Employee getEmployeeByUser(String user) {
        return employeeDao.getEmployeeByUser(user);
    }

    @Override
    public Employee getEmployeeByUid(int uid) {
        return employeeDao.getEmployeeByUid(uid);
    }
}
