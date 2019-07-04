package com.study.dao;

import com.study.domain.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountDao {
    List<Account> findAll() throws SQLException;
    Account getById(Integer id) throws SQLException;
    Integer insert(Account account) throws SQLException;
    Integer update(Account account)throws SQLException;
}
