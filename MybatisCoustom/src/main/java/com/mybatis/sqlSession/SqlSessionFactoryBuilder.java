package com.mybatis.sqlSession;

import com.mybatis.cfg.Configuration;
import com.mybatis.sqlSession.defaults.DefaultSqlSessionFactory;
import com.mybatis.untils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream stream) {
        Configuration configuration = XMLConfigBuilder.loadConfiguration(stream);
        return new DefaultSqlSessionFactory(configuration);
    }
}
