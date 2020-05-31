package com.hy.multipledatasources.employee.service;

import com.hy.multipledatasources.employee.entity.Employee;

import java.util.List;

/***
 * @description
 * @author hy
 * @date 2020/5/31 13:39
 **/
public interface EmployeeService {

    /**
     * 员工：查询所有
     * @return 、
     */
    List<Employee> findAll();

    /***
     * 员工：新增
     * @param employee 、
     */
    void save(Employee employee);
}
