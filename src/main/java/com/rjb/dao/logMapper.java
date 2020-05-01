package com.rjb.dao;

import com.rjb.bean.log;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface logMapper {
    void insertLog(log l);
    @ResultMap("forLog")
    @Select("select *from log where type = #{type} ")
    List<log> selectLog(String type);
}
