package com.study.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.study.service.IAccountService;

/**
 * @Author: caolf
 * @Date: 2019/7/4 17:46
 */
//这里使用Duboo的Service
@Service
public class AccmountService implements IAccountService {
    @Override
    public String getName() {
        System.out.println("dubbo-Provider accountService");
        return "dubbo-Provider accountService";
    }
}
