package com.test.unittest;

import com.test.dao.UserDao;
import com.test.domain.User;
import org.junit.Test;
import org.springframework.util.Assert;

public class UserDaoTest {

    @Test
    public void  getUser(){

        UserDao dao=new UserDao();
        User user = dao.getUser("张三", "123456");
        Assert.notNull(user, "user未找到");
    }

}
