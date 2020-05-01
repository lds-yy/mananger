package com.rjb.test;

import com.rjb.bean.log;
import com.rjb.bean.users;
import com.rjb.service.impl.shopServiceImpl;
import com.rjb.service.shopService;
import com.rjb.util.Pager;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class test1 {
    ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("spring/spring-service.xml");
    @Test
    public void test(){

            shopServiceImpl shop = (shopServiceImpl)applicationContext.getBean("shop");
            int i = shop.coun();
            System.out.println(i);
            Pager pager = new Pager();
            pager.setPageIndex(1);
            List<users> list = shop.find(pager,"男","罗");
            for(users u:list){
               System.out.println(u.getName());
            }
            System.out.println(list.toString());
        System.out.println(pager.getTotalPages());
        System.out.println(pager.getPageSize());
        System.out.println(pager.getPageIndex());
        System.out.println(pager.getTotalCount());
        System.out.println(pager.getFirstParam());
    }
    @Test
    public void demo2(){
        shopServiceImpl shop = (shopServiceImpl)applicationContext.getBean("shop");
        Map<String,Object> map = shop.staffBy("2141","123");
        System.out.println(map.get("msg"));
    }
}
