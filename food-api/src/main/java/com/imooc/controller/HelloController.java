package com.imooc.controller;

import com.imooc.pojo.Stu;
import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.websocket.server.PathParam;

/**
 * Created by lihu on 2020/11/4.
 *
 * @author lihu
 * @date 2020/11/4
 */
@ApiIgnore
@RestController
public class HelloController {
    private StuService stuService;

    @Autowired
    public void setStuService(StuService stuService) {
        this.stuService = stuService;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello, World";
    }

    @GetMapping("/stu/{id}")
    public Stu getStu(@PathVariable Integer id){
        return stuService.findById(id);
    }
}
