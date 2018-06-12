package com.haocheng.analysissystem.controller;

import com.haocheng.analysissystem.bean.VipEntity;
import com.haocheng.analysissystem.bean.YhxxEntity;
import com.haocheng.analysissystem.service.YhxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class YhxxAction {

    @Autowired
    private YhxxService yhxxService;

    /**
     * 根据手机号获取到某个用户信息
     * @param tel
     * @return
     */
    @RequestMapping("/togetyhxx")
    public ModelAndView togetyhxx(String tel){
        YhxxEntity byTel = yhxxService.findByTel(tel);
        ModelAndView mv = new ModelAndView();
        mv.addObject("byTel", byTel);
        if (byTel == null){
            mv.setViewName("error");
        }else{
            mv.setViewName("yhxx_res");
        }
        return mv;
    }

    /**
     * 获取在网用户总量
     */
    @RequestMapping("/getUserNum")
    @ResponseBody
    public Integer getUserNum(){
        int userNum = yhxxService.getUserNum();
        return userNum;
    }

    /**
     * 获取在网用户会员等级
     */
    @RequestMapping("/toGetVip")
    public String toGetVip(){
        return "echarts/radar";
    }

    @RequestMapping("/getVip")
    @ResponseBody
    public List<VipEntity> getVip(){
        List<VipEntity> viplist = yhxxService.getVip();
        return viplist;
    }

}
