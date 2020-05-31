package com.hy.multipledatasources.user.service;

import com.hy.multipledatasources.user.entity.User;
import com.hy.multipledatasources.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/***
 * @description
 * @author hy
 * @date 2020/5/31 13:33
 **/
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "secondaryTransactionManager")
    public void save(User user) {
        userRepository.save(user);
    }
}
