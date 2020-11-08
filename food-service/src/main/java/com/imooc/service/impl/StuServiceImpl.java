package com.imooc.service.impl;

import com.imooc.mapper.StuMapper;
import com.imooc.pojo.Stu;
import com.imooc.service.StuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/8.
 *
 * @author lihu
 * @date 2020/11/8
 */
@Service
public class StuServiceImpl implements StuService {

    @Resource
    private StuMapper stuMapper;

    @Override
    public Stu findById(Integer id) {
        return stuMapper.findById(id);
    }

    @Override
    public void insert(Stu stu) {
        stuMapper.insert(stu);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void insertFirst() {
        stuMapper.insert(createStu(1,"Fist",18));
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void insertSecond() {
        stuMapper.insert(createStu(2,"Second1",18));
        int a = 1/0;
        stuMapper.insert(createStu(3,"Second2",18));
    }

    @Override
    public void insetDemoData() {

    }

    private Stu createStu(Integer id, String name, Integer age) {
        Stu stu = new Stu();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        return stu;
    }
}
