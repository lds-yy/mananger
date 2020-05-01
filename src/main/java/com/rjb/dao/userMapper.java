package com.rjb.dao;

import com.rjb.bean.users;
import com.rjb.util.Pager;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface userMapper {

    List<users> finAll(@Param("pager") Pager pager,@Param("sex") String sex,@Param("name") String name);

    users findByid(users user);

    void addUser(users user);
    @Delete("delete from users where uid = #{xxxx}")
    void delete(Integer id);
    void updateUser(users user);
    @Select("select count(*) from users")
    int count();
}
