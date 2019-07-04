package com.study.dao.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: caolf
 * @Date: 2019/7/2 17:32
 */
@Component("connectionUtils")
public class ConnectionUtils {
    //ConnectionUtils 如果是单列的 ThreadLocal可以不是静态的 一般使用静态
    private final static ThreadLocal<Connection> localConnection = new ThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource;

    public Connection getConnection() {
        Connection connection = localConnection.get();
        if (connection != null) {
            return connection;
        } else {

            try {
                Connection connection1 = dataSource.getConnection();

                localConnection.set(connection1);
                return connection1;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

    }

    public void removeConnection() {
        System.out.println("remove");
        localConnection.remove();
    }
}
