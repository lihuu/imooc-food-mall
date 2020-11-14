package com.imooc.service;

import com.imooc.pojo.Stu;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/8.
 *
 * @author lihu
 * @date 2020/11/8
 */
public interface StuService {
    /**
     * @param id
     * @return
     */
    Stu findById(Integer id);

    /**
     * Test
     *
     * @param stu
     */
    void insert(Stu stu);

    void insertFirst();

    void insertSecond();

    void insetDemoData();

}
