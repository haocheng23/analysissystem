package com.haocheng.analysissystem.controller;

import com.haocheng.analysissystem.util.SendHttp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexAction {

    @RequestMapping("/index")
    public String index(){
        return "index.html";
    }

    @RequestMapping("/toyhxx")
    public String toyhxx(){
        return "search";
    }

    @RequestMapping("/tocxcp")
    public String tocxcp(){
        return "echarts/pie";
    }

    @RequestMapping("/toxwfx")
    public String toxwfx(){
        return "xwfx";
    }

    @RequestMapping("/sendFile")
    public String sendFile(String srcpath){
        SendHttp.postJson(srcpath);
        return "redirect:/index";
    }

}
