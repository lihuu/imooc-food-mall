package com.imooc.controller;

import com.imooc.common.model.ApiResponse;
import com.imooc.service.UserService;
import com.imooc.service.model.UserBO;
import com.imooc.utils.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/16.
 *
 * @author lihu
 * @date 2020/11/16
 */
@RestController
@RequestMapping("/passport")
public class PassportController {
    private UserService userService;

    public PassportController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/checkUserExist")
    public ApiResponse checkUserExist(@RequestParam(value = "username") String userName) {
        return ApiResponse.ok(userService.isUserExist(userName));
    }

    @PostMapping("/register")
    public ApiResponse register(@RequestBody UserBO userBO) {
        String userName = userBO.getUserName();
        String password = userBO.getPassword();
        String confirmPassword = userBO.getConfirmPassword();

        if (StringUtils.isEmpty(userName)) {
            return ApiResponse.errorMessage("用户名不能为空");
        }

        if (userService.isUserExist(userName)) {
            return ApiResponse.errorMessage("用户名已经存在");
        }

        if (StringUtils.equals(password, confirmPassword)) {
            return ApiResponse.errorMessage("两次密码输入不一致");
        }

        if (password.length() < 6) {
            return ApiResponse.errorMessage("密码长度不能少于6位");
        }

        return ApiResponse.ok("用户注册成功");

    }

}
