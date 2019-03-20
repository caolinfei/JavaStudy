package com.study.until;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.study.jdbcConnectionPool.DruidDemo;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCUntilsForJDBCTempLate {

    public static DataSource dataSource = null;

    /**
     *初始化dataSource
     *
     */
    static {
        Properties properties = new Properties();
        try {
            properties.load(JDBCUntilsForJDBCTempLate.class.getClassLoader().getResourceAsStream("com/druid.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
