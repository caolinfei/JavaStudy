package com.study.dao;

import com.study.domian.User;

import java.util.List;

public interface IUserDao {
    /**
     *
     * 查询所有
     * @return 用户列表
     */
    List<User> findAll();
}
