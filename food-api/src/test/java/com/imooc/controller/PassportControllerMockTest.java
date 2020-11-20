package com.imooc.controller;

import com.imooc.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/17.
 * 使用mock方式测试
 *
 * @author lihu
 * @date 2020/11/17
 */
//@WebMvcTest(PassportController.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
//，如果使用的是org.junit.jupiter.api.Test注解，不需要这个
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class PassportControllerMockTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkUserExistTest() throws Exception {
        MvcResult mvcResult =
            this.mockMvc.perform(MockMvcRequestBuilders.get("/passport/checkUserExist?username=imooc123"))
                .andExpect(status().isOk()).andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }
}
