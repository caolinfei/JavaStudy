package com.study.dao;

import com.study.domian.Account;

import java.util.List;

public interface IAccountDao {

     List<Account> findAccountByUid (int uid);
}
