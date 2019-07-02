package com.study.dao.impl;

import com.study.dao.IAccountDao;
import com.study.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("accountDao")
public class AccountDao implements IAccountDao {
    @Autowired
    private QueryRunner runner;

    public List<Account> findAll() throws SQLException {
        return  runner.query("select * from account",new BeanListHandler<Account>(Account.class));

    }
    public Account getById(Integer id) throws SQLException {
        return  runner.query("select * from account where id=?",new BeanHandler<Account>(Account.class),id);

    }

    public Integer insert(Account account) throws SQLException {
        return  runner.update("insert into account (name,money) Values(?,?)",
                account.getName(),
                account.getMoney());

    }

    public Integer update(Account account) throws SQLException {
        return  runner.update("update account set name=?,money=? where id=?",
                account.getName(),
                account.getMoney(),
                account.getId());

    }
}
