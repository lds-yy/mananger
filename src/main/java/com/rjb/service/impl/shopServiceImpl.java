package com.rjb.service.impl;

import com.rjb.bean.Address;
import com.rjb.bean.log;
import com.rjb.bean.staff;
import com.rjb.bean.users;
import com.rjb.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public interface shopServiceImpl {
    public List<users> find(Pager pager,String sex,String name);
    users fiBy(Integer id);
    Address addreBy(Integer id);
    void addUs(users user);
    void Less(Integer id);
    void update(users user);
    Map<String,Object> staffBy(String username,String password);
    void addSta(String username,String password);
    int coun();
    void increase(log l);
    List<log> saveLog(String type);
}
