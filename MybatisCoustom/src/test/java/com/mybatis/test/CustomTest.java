package com.mybatis.test;

import com.mybatis.sqlSession.SqlSession;
import com.mybatis.sqlSession.SqlSessionFactory;
import com.mybatis.sqlSession.SqlSessionFactoryBuilder;
import com.mybatis.untils.Resources;
import com.service.dao.IUserDao;
import com.service.domain.User;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class CustomTest {

    @Test
    public void coustomMyBatisTest() {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        //以数据库查询出来result为准 来实体内找对应字段
        List<User> all = mapper.findAll();

        System.out.println(all);


    }
}
