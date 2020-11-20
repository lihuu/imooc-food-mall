package com.imooc.service;

import com.imooc.common.BaseTest;
import com.imooc.service.model.UserBO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/16.
 *
 * @author lihu
 * @date 2020/11/16
 */
public class UserServiceTest extends BaseTest {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void isUserExistTest() {
        String userName = "";
        boolean result = userService.isUserExist(userName);
        assert !result;

        result = userService.isUserExist("imooc123");
        assert result;
    }

    @Transactional
    @Test
    public void testSave() {
        UserBO userBO = UserBO.builder().userName("admin").password("admin").build();
        userService.saveUser(userBO);
        assert userService.isUserExist("admin");
    }

}
