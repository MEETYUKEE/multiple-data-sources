package com.hy.multipledatasources.employee.service;

import com.hy.multipledatasources.employee.entity.Employee;
import com.hy.multipledatasources.employee.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/***
 * @description
 * @author hy
 * @date 2020/5/31 13:41
 **/
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "primaryTransactionManager")
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}
