package com.rjb.dao;

import com.rjb.bean.staff;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface staffMapper {
    @Select("select *from staff where username = #{xxxx}")
    staff staffByid(String name);
    @Insert("insert into staff(username,password) values(#{username},#{password})")
    void addStaff(@Param("username") String username,@Param("password") String password);
}
