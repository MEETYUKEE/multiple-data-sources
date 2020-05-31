package com.hy.multipledatasources.user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/***
 * @description 用户
 * @author hy
 * @date 2020/5/31 13:29
 **/
@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User implements Serializable {

    public User(String userName){
        this.userName = userName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;
}
