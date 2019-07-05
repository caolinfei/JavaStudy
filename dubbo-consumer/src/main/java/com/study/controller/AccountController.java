package com.study.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.study.service.IAccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: caolf
 * @Date: 2019/7/5 14:12
 */
@RequestMapping("/account")
public class AccountController {

    @Reference
    private IAccountService accountService;



    @ResponseBody
    @RequestMapping(value = "/name")
    public  String accountName(){
      return   accountService.getName();
    }
}
