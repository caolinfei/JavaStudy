package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: caolf
 * @Date: 2019/7/8 11:56
 */
@Controller
@RequestMapping("/home")
public class TestController {

    @RequestMapping("/index")
    public String Index (){
        return "index";
    }
}
