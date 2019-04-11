package com.service.dao;

import com.service.domain.User;

import java.util.List;

public interface IUserDao {

   public List<User> findAll();
}
