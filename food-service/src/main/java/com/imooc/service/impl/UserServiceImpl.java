package com.imooc.service.impl;

import com.imooc.entity.User;
import com.imooc.repository.UserRepository;
import com.imooc.service.UserService;
import com.imooc.service.model.UserBO;
import com.imooc.utils.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean isUserExist(String userName) {
        User user = userRepository.findByUserName(userName);
        return user != null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,
        rollbackFor = Exception.class)
    public boolean saveUser(UserBO userBO) {
        User user = User.builder().userName(userBO.getUserName()).face("https://dasgadsfadsfa.cadfa")
            .password(MD5Util.shaEncrypt(userBO.getPassword())).build();
        userRepository.save(user);
        return true;
    }
}
