package com.study.jdbcConnectionPool;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.study.entity.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jdbcPool得简单实用
 */
public class Demo01C3p0 {
    public static void main(String[] args) {
        DataSource ds = new ComboPooledDataSource();
        Connection connection = null;
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select  * from student");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println(name);

            }
            //System.out.println(resultSet);
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
