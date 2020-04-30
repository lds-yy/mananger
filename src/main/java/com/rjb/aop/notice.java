package com.rjb.aop;

import com.rjb.bean.log;
import com.rjb.bean.staff;
import com.rjb.service.shopService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@Component
@Aspect
public class notice {
    @Resource
    shopService shop;
    @After("execution(* com.rjb.controll.myHandler.insert(..))")
    public void insertLog(JoinPoint Join){
        log l = new log();
        l.setMoudle(Join.getTarget().getClass().getSimpleName());
        l.setOperator(Join.getSignature().getName());
        HttpServletRequest httpServletRequest = (HttpServletRequest)Join.getArgs()[0];
        HttpSession session = httpServletRequest.getSession();
        staff s = (staff)session.getAttribute("staff");
        l.setOpration(s.getUsername());
        l.setResult("成功");
        l.setOprTime(new Date());
        l.setType("Operating");
        shop.increase(l);
    }
    @After("execution(* com.rjb.controll.myHandler.delete(..))")
    public void insertLog0(JoinPoint Join){
        log l = new log();
        l.setMoudle(Join.getTarget().getClass().getSimpleName());
        l.setOperator(Join.getSignature().getName());
        HttpServletRequest httpServletRequest = (HttpServletRequest)Join.getArgs()[0];
        HttpSession session = httpServletRequest.getSession();
        staff s = (staff)session.getAttribute("staff");
        l.setOpration(s.getUsername());
        l.setResult("成功");
        l.setOprTime(new Date());
        l.setType("Operating");
        shop.increase(l);
    }
    @After("execution(* com.rjb.controll.myHandler.update(..))")
    public void insertLog1(JoinPoint Join){
        log l = new log();
        l.setMoudle(Join.getTarget().getClass().getSimpleName());
        l.setOperator(Join.getSignature().getName());
        HttpServletRequest httpServletRequest = (HttpServletRequest)Join.getArgs()[0];
        HttpSession session = httpServletRequest.getSession();
        staff s = (staff)session.getAttribute("staff");
        l.setOpration(s.getUsername());
        l.setResult("成功");
        l.setOprTime(new Date());
        l.setType("Operating");
        shop.increase(l);
    }
    @AfterThrowing(throwing = "e",pointcut = "execution(* com.rjb.controll.myHandler.*.*(..))")
    public void throwing(JoinPoint Join,Throwable e){
        log l = new log();
        l.setMoudle(Join.getTarget().getClass().getSimpleName());
        l.setOperator(Join.getSignature().getName());
        HttpServletRequest httpServletRequest = (HttpServletRequest)Join.getArgs()[0];
        HttpSession session = httpServletRequest.getSession();
        staff s = (staff)session.getAttribute("staff");
        l.setOpration(s.getUsername());
        l.setResult("异常:"+e.getClass().getSimpleName());
        l.setOprTime(new Date());
        l.setType("Throw");
        shop.increase(l);
    }
    @After("execution(* com.rjb.controll.myHandler.login(..))")
    public int insertLogin(JoinPoint Join) {
        log l = new log();
        l.setMoudle(Join.getTarget().getClass().getSimpleName());
        l.setOperator(Join.getSignature().getName());
        HttpServletRequest httpServletRequest = (HttpServletRequest)Join.getArgs()[0];
        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("staff")==null){
            return 1;
        }
        staff s = (staff)session.getAttribute("staff");
        l.setOpration(s.getUsername());
        l.setResult("登录成功");
        l.setOprTime(new Date());
        l.setType("login");
        shop.increase(l);
        return 1;
    }
    @Before("execution(* com.rjb.controll.myHandler.exit(..))")
    public void LoginOut(JoinPoint Join){
        log l = new log();
        l.setMoudle(Join.getTarget().getClass().getSimpleName());
        l.setOperator(Join.getSignature().getName());
        HttpServletRequest httpServletRequest = (HttpServletRequest)Join.getArgs()[0];
        HttpSession session = httpServletRequest.getSession();
        staff s = (staff)session.getAttribute("staff");
        l.setOpration(s.getUsername());
        l.setResult("退出");
        l.setOprTime(new Date());
        l.setType("login");
        shop.increase(l);
    }
}
