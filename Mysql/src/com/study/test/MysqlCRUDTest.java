package com.study.test;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.study.entity.Student;
import com.study.until.JDBCUntil;
import org.junit.Test;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlCRUDTest {

    //use jdbc utils
    @Test
    public void InsertIntotest() {

        try {
            Connection connec = JDBCUntil.getConnection();
            PreparedStatement preparedStatement = connec.prepareStatement("insert  into student values (?,?,?,null ,?)");
            preparedStatement.setString(1, "慕容晓晓");
            preparedStatement.setInt(2, 18);
            preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setBigDecimal(4, new BigDecimal(1000));
            int affected = preparedStatement.executeUpdate();
            if (affected > 0) {
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Query() {
        try {
            List<Student> students = new ArrayList<>();
            Connection connection = JDBCUntil.getConnection();
            PreparedStatement pre = connection.prepareStatement("select  *from student where name=?");
            pre.setString(1, "李四");
            ResultSet result = pre.executeQuery();
            Student s = null;
            while (result.next()) {
                s = new Student();
                s.setName(result.getString("name"));
                s.setAge(result.getInt("age"));
                s.setDate(result.getTimestamp("date"));
                //s.setAmoutn(result.getBigDecimal("amount"));
                s.setId(result.getInt("id"));
                students.add(s);

            }
            System.out.println(students.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test1(){
        try {
           // Class.forName("com.study.test.TestClassForName");
            Object o = Class.forName("com.study.test.TestClassForName").newInstance();
            System.out.println(o.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void TestMysqlPool()
    {
        DataSource ds=new MysqlDataSource();
    }
}
