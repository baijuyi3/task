package com.jy.dao;

import com.jy.model.Department;

import java.util.List;

/**
 * Created by Administrator on 2018/10/25.
 */
public interface DepartmentDao {
    int saveDepartment(Department department);
    int delDepartment(int id);
    int updateDepartment(Department department);
    List<Department> getAllDepartment();
    Department getDepartmentById(int id);
}
