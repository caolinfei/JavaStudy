package com.study.service;


import com.study.domain.Account;

import java.math.BigDecimal;
import java.util.List;

public interface IAccountService {

    List<Account> findAll();

    Account getById(Integer id);

    Integer update(Account account);

    Integer inster(Account account);

    void transfer(int fromId, int toId, BigDecimal money);
    void transfer2() ;
}
