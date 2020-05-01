package com.rjb.controll;

import com.rjb.bean.Address;
import com.rjb.bean.log;
import com.rjb.bean.staff;
import com.rjb.bean.users;
import com.rjb.service.impl.shopServiceImpl;
import com.rjb.util.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class myHandler {
    @Resource
    shopServiceImpl shopService;
    @RequestMapping("/index")
    public ModelAndView modelAndView(HttpServletRequest request, HttpServletResponse response, Object j
   ,@RequestParam(value = "sex")  String sex,@RequestParam(value = "name")  String name){
        ModelAndView modelAndView = new ModelAndView();
        int index = Integer.parseInt(request.getParameter("pageIndex"));
                Pager pager = new Pager();
                pager.setPageIndex(index);
        List<users> list = shopService.find(pager,sex,name);
        modelAndView.addObject("usersList",list);
        modelAndView.addObject("pager",pager);
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping("/detail")
    public ModelAndView modelAndView1(HttpServletRequest request, HttpServletResponse response,Object j){
        ModelAndView modelAndView = new ModelAndView();
        Integer id = Integer.parseInt(request.getParameter("uid"));
        users user = shopService.fiBy(id);
        Address address = shopService.addreBy(id);
        modelAndView.addObject("user",user);
        modelAndView.addObject("address",address);
        modelAndView.setViewName("detail");
        return modelAndView;
    }
    @RequestMapping("/abusers")
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response,Object j) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        //把数据封装到对象
        users user = new users(username,password,nickname,Integer.parseInt(age),gender,phone,new Date(),new Date(),new Date(),0);
        shopService.addUs(user);

        modelAndView.setViewName("jump");
        return modelAndView;
    }
    @RequestMapping("/deluser")
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response,Object j) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        Integer id = Integer.parseInt(request.getParameter("uid"));
        String type = request.getParameter("type");
        //锁定
        if("unlock".equals(type)){
            users user = new users();
            user.setUid(id);
            user.setUserStatus(1);
            shopService.update(user);
        }else if("del".equals(type)){
            //删除
            shopService.Less(id);
        }else if("lock".equals(type)){
            //解锁操作
            users user = new users();
            user.setUid(id);
            user.setUserStatus(0);
            shopService.update(user);
        }
        modelAndView.setViewName("jump");
        return modelAndView;
    }
    @RequestMapping("/updateusers")
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response,Object j) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        String uid = request.getParameter("id");
        String nickname = request.getParameter("nickname");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String remark = request.getParameter("remark");
        //把数据封装在数据库
        users user = new users(Integer.parseInt(uid),nickname,Integer.parseInt(age),gender,phone,new Date(),remark);
        shopService.update(user);
        modelAndView.setViewName("jump");
        return modelAndView;
    }
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, Object j,
                                      @RequestParam(value = "username") String username,@RequestParam(value = "password") String password
    ,@RequestParam(value = "pass") String pass) throws IOException {
        String pa = "0000";
        ModelAndView modelAndView = new ModelAndView();
        if(!pass.equals(pa)){
            modelAndView.addObject("msg","管理码出错");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        Map<String,Object> map = shopService.staffBy(username,password);
        String code = "code";
        if((Integer) map.get(code)==0){
            HttpSession session = request.getSession();
            staff st = (staff)map.get("msg");
            session.setAttribute("staff",st);
            modelAndView.setViewName("jump");
        }else{
            modelAndView.addObject("msg",map.get("msg"));
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
    @RequestMapping("/regist")
    public ModelAndView regist(HttpServletRequest request, HttpServletResponse response, Object j,
                                      @RequestParam(value = "username") String username,@RequestParam(value = "password") String password,
    @RequestParam(value = "pass") String pass) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
       if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
           response.sendRedirect("regist.jsp");
       }
        if(password.equals(pass)==false){
            modelAndView.setViewName("regist");
            return modelAndView;
        }
        shopService.addSta(username, password);
       modelAndView.setViewName("login");
        return modelAndView;
    }
    @RequestMapping("/exit")
    public ModelAndView exit(HttpServletRequest request, HttpServletResponse response, Object j) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
       request.getSession().removeAttribute("staff");
       modelAndView.setViewName("login");
        return modelAndView;
    }
    @RequestMapping("/log")
    public ModelAndView log(){
        ModelAndView modelAndView = new ModelAndView();
       List<log> list1 = shopService.saveLog("Operating");
       modelAndView.addObject("Operating",list1);
       modelAndView.addObject("opera","操作日志");
        List<log> list2 = shopService.saveLog("login");
        modelAndView.addObject("login",list2);
        modelAndView.addObject("Lo","登录日志");
        List<log> list3 = shopService.saveLog("Throw");
        modelAndView.addObject("Throw",list3);
        modelAndView.addObject("th","异常日志");
        modelAndView.setViewName("Log");
        return modelAndView;
    }
}
