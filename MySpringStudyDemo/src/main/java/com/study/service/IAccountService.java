package com.study.service;


import com.study.domain.Account;

import java.util.List;

public interface IAccountService {

    List<Account> findAll();

    Account getById(Integer id);

    Integer update(Account account);

    Integer inster(Account account);
}
