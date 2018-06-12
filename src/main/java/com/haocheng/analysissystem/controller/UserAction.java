package com.haocheng.analysissystem.controller;

import com.haocheng.analysissystem.bean.KfxxEntity;
import com.haocheng.analysissystem.bean.LoginEntity;
import com.haocheng.analysissystem.service.KfxxService;
import com.haocheng.analysissystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserAction {

    @Autowired
    private UserService userService;

    @Autowired
    private KfxxService kfxxService;

    @RequestMapping("/")
    public String toLogin(){
        return "login.html";
    }

    /**
     * 登录系统
     * @param response
     * @param session
     * @param loginEntity
     * @throws Exception
     */
    @PostMapping("/login")
    public void login(HttpServletResponse response, HttpSession session, LoginEntity loginEntity) throws Exception{
        //查询数据库并判断用户名和密码是否正确
        LoginEntity user = userService.findByUsernameAndPassword(loginEntity);
        if(user==null){
            response.getWriter().write("1"); //用户名或密码错误
        }else{
            session.setAttribute("user", user);
            response.getWriter().write("2");  //成功查到该用户
        }
    }

    /**
     * 安全退出
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    /**
     * 客服信息
     */
    @RequestMapping("/getKfxx")
    public List<KfxxEntity> getKfxx(){
        List<KfxxEntity> list = kfxxService.getAll();
        return list;
    }

    /*
    * 当前在线客服人数
    * */
    @RequestMapping("/getServicerNum")
    @ResponseBody
    public Integer getServicerNum(){
        int servicerNum = kfxxService.getServicerNum();
        return servicerNum;
    }
}
