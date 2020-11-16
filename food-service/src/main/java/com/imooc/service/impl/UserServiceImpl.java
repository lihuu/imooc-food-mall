package com.imooc.service.impl;

import com.imooc.pojo.User;
import com.imooc.repository.UserRepository;
import com.imooc.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/16.
 *
 * @author lihu
 * @date 2020/11/16
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isUserExist(String userName) {
        User user = userRepository.findByUserName(userName);
        return user != null;
    }
}
