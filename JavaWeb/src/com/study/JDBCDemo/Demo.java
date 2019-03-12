package com.study.JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/mytest",
                        "root", "root");

        String sql="UPDATE test SET  name='曹麟飞' WHERE Id=1";
        Statement stm=connection.createStatement();
        int i = stm.executeUpdate(sql);
        System.out.println(i);

    }
}
