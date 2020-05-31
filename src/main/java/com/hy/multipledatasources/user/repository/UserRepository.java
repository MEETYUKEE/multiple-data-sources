package com.hy.multipledatasources.user.repository;

import com.hy.multipledatasources.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/***
 * @description
 * @author hy
 * @date 2020/5/31 13:33
 **/
public interface UserRepository extends JpaRepository<User, Long>,
        JpaSpecificationExecutor<User> {
}
