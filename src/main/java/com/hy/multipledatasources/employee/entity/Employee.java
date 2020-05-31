package com.hy.multipledatasources.employee.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/***
 * @description 员工
 * @author hy
 * @date 2020/5/31 13:38
 **/
@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
public class Employee implements Serializable {

    public Employee(String empName){
        this.empName = empName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;

}
