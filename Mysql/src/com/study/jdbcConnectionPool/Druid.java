package com.study.jdbcConnectionPool;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 *
 * druid连接池
 */
public class Druid {

    public static void main(String[] args) {
        Properties p=new Properties();
        try {

            InputStream is = Druid.class.getClassLoader().getResourceAsStream("com/study/jdbcConnectionPool/druid.properties");
            p.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            DataSource dataSource = DruidDataSourceFactory.createDataSource(p);
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update student set name='helloword' where id=1");
            int i = preparedStatement.executeUpdate();
            if(i>0){
                System.out.println("成功");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
