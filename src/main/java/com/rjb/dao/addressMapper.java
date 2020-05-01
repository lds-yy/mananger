package com.rjb.dao;

import com.rjb.bean.Address;
import com.rjb.bean.users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface addressMapper {
    @Select("select *from address where userid = #{xxxx}")
    Address addressByid(Integer id);
}
