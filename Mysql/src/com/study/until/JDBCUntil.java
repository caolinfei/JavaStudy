package com.study.until;

import com.mysql.jdbc.jdbc2.optional.ConnectionWrapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Enumeration;
import java.util.Properties;

public class JDBCUntil {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 初始化jar包
     */
    static {
       /* try {
            Class.forName("com.mysql.jdbc.Driver")
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        Properties properties = new Properties();
        ClassLoader classLoader = JDBCUntil.class.getClassLoader();

        URL res = classLoader.getResource("jdbc.properties");
        String path = res.getPath();
        try {

            properties.load(new FileReader(path));
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void Dispose(Connection con, Statement statement) throws SQLException {
        if (con != null) {
            con.close();
        }
        if (statement != null) {
            statement.close();
        }
    }

    public static void Dispose(ResultSet set, Connection con, Statement statement)  {
        if (set != null) {
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
