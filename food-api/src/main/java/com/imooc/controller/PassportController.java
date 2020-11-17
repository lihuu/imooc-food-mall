package com.imooc.controller;

import com.imooc.common.model.ApiResponse;
import com.imooc.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
