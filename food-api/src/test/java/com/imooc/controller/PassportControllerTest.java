package com.imooc.controller;

import com.imooc.common.model.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

/**
 * 用这种方式测试rest接口
 * Created by 1449488533qq@gmail.com on 2020/11/17.
 *
 * @author lihu
 * @date 2020/11/17
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringJUnit4ClassRunner.class)
public class PassportControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    /**
     * 注意这个Test注解的包名
     */
    @Test
    public void checkUserExistTest() {
        ApiResponse apiResponse = this.testRestTemplate
            .getForObject("http://localhost:" + port + "/passport/checkUserExist?username=imooc123", ApiResponse.class);
        assert "200".equals(apiResponse.getCode());
    }

}
