package com.hy.multipledatasources.employee.repository;

import com.hy.multipledatasources.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/***
 * @description
 * @author hy
 * @date 2020/5/31 13:39
 **/
public interface EmployeeRepository extends JpaRepository<Employee, Long>,
        JpaSpecificationExecutor<Employee> {
}
