package com.hy.multipledatasources.contrller;

import com.hy.multipledatasources.employee.entity.Employee;
import com.hy.multipledatasources.employee.service.EmployeeService;
import com.hy.multipledatasources.user.entity.User;
import com.hy.multipledatasources.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***
 * @description 多数据源测试控制器
 * @author hy
 * @date 2020/5/31 13:21
 **/
@RestController
@RequestMapping("multipleDataSources")
@AllArgsConstructor
public class MultipleDataSourcesController {

    private final UserService userService;
    private final EmployeeService employeeService;

    /***
     * 查询所有用户信息
     * @return 、
     */
    @GetMapping("findAllUser")
    public ResponseEntity<Object> findAllUser(){
        return ResponseEntity.ok(userService.findAll());
    }

    /***
     * 新增用户
     * @param userName 用户名称
     * @return 、
     */
    @PostMapping("addUser")
    public ResponseEntity<Object> addUser(@RequestParam String userName){
        userService.save(new User(userName));
        return ResponseEntity.noContent().build();
    }

    /***
     * 查询所有员工信息
     * @return 、
     */
    @GetMapping("findAllEmp")
    public ResponseEntity<Object> findAllEmp(){
        return ResponseEntity.ok(employeeService.findAll());
    }

    /***
     * 新增员工
     * @param empName 员工姓名
     * @return 、
     */
    @PostMapping("addEmp")
    public ResponseEntity<Object> addEmp(@RequestParam String empName){
        employeeService.save(new Employee(empName));
        return ResponseEntity.noContent().build();
    }
}
