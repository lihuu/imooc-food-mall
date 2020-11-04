package com.imooc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lihu on 2020/11/4.
 *
 * @author lihu
 * @date 2020/11/4
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello, World";
    }
}
