package com.mybatis.sqlSession.defaults;

import com.mybatis.cfg.Configuration;
import com.mybatis.sqlSession.SqlSession;
import com.mybatis.sqlSession.SqlSessionFactory;


public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg=cfg;
    }

    public SqlSession openSession() {
        return new DefaultSqlSession(this.cfg);
    }
}
