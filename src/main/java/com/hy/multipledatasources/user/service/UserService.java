package com.hy.multipledatasources.user.service;

import com.hy.multipledatasources.user.entity.User;

import java.util.List;

/***
 * @description
 * @author hy
 * @date 2020/5/31 13:33
 **/
public interface UserService {

    /***
     * 用户：查询所欲用户新
     * @return 、
     */
    List<User> findAll();

    /***
     * 用户：新增
     * @param user 用户信息
     */
    void save(User user);
}
