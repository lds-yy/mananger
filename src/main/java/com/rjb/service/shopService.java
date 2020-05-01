package com.rjb.service;

import com.rjb.bean.Address;
import com.rjb.bean.log;
import com.rjb.bean.staff;
import com.rjb.bean.users;
import com.rjb.dao.addressMapper;
import com.rjb.dao.logMapper;
import com.rjb.dao.staffMapper;
import com.rjb.dao.userMapper;
import com.rjb.service.impl.shopServiceImpl;
import com.rjb.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("shop")
public class shopService implements shopServiceImpl {
    @Resource
    userMapper userMa;
    @Resource
    addressMapper address;
    @Resource
    staffMapper staff;
    @Resource
    logMapper logM;
    public List<users> find(Pager pager,String sex,String name) {
        int count = userMa.count();
        pager.setTotalCount(count);
        List<users> list = userMa.finAll(pager,sex,name);
        return list;
    }

    public users fiBy(Integer uid) {
        users us = userMa.findByid(new users(uid));
        return us;
    }

    public Address addreBy(Integer id) {
        Address add= address.addressByid(id);
        return add;
    }

    public void addUs(users user) {
        userMa.addUser(user);
    }

    public void Less(Integer id) {
        userMa.delete(id);
    }

    public void update(users user) {
        userMa.updateUser(user);
    }

    public Map<String,Object> staffBy(String username,String password) {
        Map<String,Object> map = new HashMap<String, Object>();
        staff st = staff.staffByid(username);
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
           map.put("code",1);
           map.put("msg","参数为空");
            return map;
        }else{
            if(st != null){
                    if (st.getPassword().equals(password)) {
                        map.put("code", 0);
                        map.put("msg", st);
                        return map;
                    } else {
                        map.put("code", 2);
                        map.put("msg", "密码错误");
                        return map;
                    }
            }else {
                map.put("code", 3);
                map.put("msg", "登录错误");
                return map;
            }
        }
    }

    public void addSta(String username, String password) {
        staff.addStaff(username,password);
    }

    public int coun() {
        return userMa.count();

    }

    public void increase(log l) {
        logM.insertLog(l);
    }

    public List<log> saveLog(String type) {
        List<log> list = logM.selectLog(type);
        return list;
    }
}
