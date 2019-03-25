package com.test.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

    //dataSource的连接池工具
    private static DataSource ds;

    //静态代码块来初始化Druid//阿里巴巴的数据库连接池
    static {
        //初始化druid的配置
        Properties ps=new Properties();
        try {
            ps.load(JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds= DruidDataSourceFactory.createDataSource(ps);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
           return ds.getConnection();
    }

    public static DataSource getdDataSource(){
        return ds;
    }
}
