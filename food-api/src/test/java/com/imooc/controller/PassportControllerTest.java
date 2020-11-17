package com.imooc.controller;

import com.imooc.common.model.ApiResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/17.
 *
 * @author lihu
 * @date 2020/11/17
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class PassportControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void test() {
        ApiResponse apiResponse = this.testRestTemplate
            .getForObject("http://localhost:" + port + "/passport/checkUserExist?username=imooc123", ApiResponse.class);
        assert "200".equals(apiResponse.getCode());
    }

}
