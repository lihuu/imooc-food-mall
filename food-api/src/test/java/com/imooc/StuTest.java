package com.imooc;

import com.imooc.pojo.Stu;
import com.imooc.service.StuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.SavepointManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/8.
 *
 * @author lihu
 * @date 2020/11/8
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StuTest {
    private StuService stuService;

    @Autowired
    public void setStuService(StuService stuService) {
        this.stuService = stuService;
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    @Rollback(value = false)
    public void test() {
        stuService.insertFirst();
        try {
            stuService.insertSecond();
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}
