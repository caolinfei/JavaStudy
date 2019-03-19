package com.study.jdbcConnectionPool;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class testC3p0maxpool {
    @Test
    public void  test(){


        DataSource ds=new ComboPooledDataSource("otherc3p0");
        for (int i = 1; i <= 11; i++) {
            try {
                Connection connection = ds.getConnection();
                System.out.println(connection);
            } catch (SQLException es) {
                es.printStackTrace();
            }

        }

    }
}
