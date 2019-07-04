package com.study.service.impl;

import com.sduty.domain.UserInfo;
import com.study.dao.IUserDao;
import com.study.service.IUserService;

public class UserInfoService implements IUserService {
    /**
     *自动注入
     *
     */
    IUserDao userDao;
    public UserInfo findById(Integer id) {
        return  userDao.findById(id);
    }
}
