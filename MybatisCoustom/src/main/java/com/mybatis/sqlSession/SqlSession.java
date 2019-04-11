package com.mybatis.sqlSession;

import java.sql.Connection;

public interface SqlSession {
    <T>T getMapper(Class<T> tClass);

    void  close(Connection con);
}
