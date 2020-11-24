package com.imooc.controller;

import com.imooc.common.model.ApiResponse;
import com.imooc.service.UserService;
import com.imooc.service.model.UserBO;
import com.imooc.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/16.
 *
 * @author lihu
 * @date 2020/11/16
 */
@Api(value = "注册登录",
    tags = {"注册登录的相关接口"})
@RestController
@RequestMapping("/passport")
public class PassportController {
    private final UserService userService;

    public PassportController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "查询用户是否存在",httpMethod = "GET",notes = "用户是否存在")
    @GetMapping("/checkUserExist")
    public ApiResponse checkUserExist(@RequestParam(value = "username") String userName) {
        return ApiResponse.ok(userService.isUserExist(userName));
    }

    @ApiOperation(value = "用户注册",httpMethod = "POST",notes = "用户注册接口")
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

        userService.saveUser(userBO);

        return ApiResponse.ok("用户注册成功");

    }

}
