package com.mybatis.sqlSession.defaults;

import com.mybatis.cfg.Configuration;
import com.mybatis.sqlSession.SqlSession;
import com.mybatis.sqlSession.proxy.MapperProxy;
import com.mybatis.untils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        connection= DataSourceUtil.getConnection(cfg);
    }

    /**
     *
     * 获取代理类
     * @param tClass
     * @param <T>
     * @return
     */
    public <T>T getMapper(Class<T> tClass){

        return (T) Proxy.newProxyInstance(tClass.getClassLoader(),new Class[]{tClass},new MapperProxy(cfg.getMappers(),connection));
    }

    public void close(Connection con) {

        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
