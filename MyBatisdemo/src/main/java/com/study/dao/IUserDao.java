package com.study.dao;

import com.study.domian.Account;
import com.study.domian.User;
import com.study.domian.UserAccount;
import com.study.domian.UserQuery;

import java.util.List;

public interface IUserDao {
    /**
     *
     * 查询所有
     * @return 用户列表
     */

   // @Select("select *,id as uid  from tb_user")
    List<User> findAll();

    User findById(Integer id);

    int insert(User user);

    void  deleteById(Integer id);

    void updateById(User user);

    int selectCount();

    User findByName(String name);

    List<User> selectByQuery(UserQuery query);

    List<UserAccount>findUserWithAccount();

    List<UserAccount>findUserRole();

    UserAccount findUserAccouunt();

    List<Account> findAccountByuId(int uid);
}
