package com.imooc.mapper;

import com.imooc.my.mapper.MyMapper;
import com.imooc.pojo.Stu;
import org.apache.ibatis.annotations.Select;

public interface StuMapper extends MyMapper<Stu> {
    //可以使用注解的方式实现

    /**
     *   <select id="findById" resultType="com.imooc.pojo.Stu"  parameterType="int">
     *    select * from Stu where id=#{id}
     *   </select>
     *
     * @param id
     * @return
     */
    @Select("select * from Stu where id=#{id}")
    Stu findById(Integer id);
}