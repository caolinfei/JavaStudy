import com.study.entity.Student;
import com.study.until.JDBCUntil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    /**
     * 1) DDL(Data Definition Language)数据定义语言
     * 用来定义数据库对象：数据库，表，列等。关键字：create, drop,alter 等
     * 2) DML(Data Manipulation Language)数据操作语言
     * 用来对数据库中表的数据进行增删改。关键字：insert, delete, update 等
     * 3) DQL(Data Query Language)数据查询语言
     * 用来查询数据库中表的记录(数据)。关键字：select, where 等
     * 4) DCL(Data Control Language)数据控制语言(了解)
     * 用来定义数据库的访问权限和安全级别，及创建用户。关键字：GRANT， REVOKE 等
     *
     * @param args
     */
    public static void main(String[] args) {

        try {

           // Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate("update student set amount =100 where id=1");
            if (i > 0) {
                System.out.println("更新 成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Student> list = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Student s = null;
        try {
            connection = JDBCUntil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from  student");
            while (resultSet.next()) {
                s = new Student();
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Timestamp time = resultSet.getTimestamp("date");
                int id = resultSet.getInt("id");
                //System.out.println("name=" + name + "age=" + age + "date" + time.toString() + "id" + id);
                s.setName(name);
                s.setAge(age);
                s.setDate(time);
                s.setId(id);
                list.add(s);
            }
            System.out.println(list.toString());
            //System.out.println(resultSet.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUntil.Dispose(resultSet, connection, statement);
        }

       // insterObject();

    }

    /**
     *添加数据
     *
     */
    private static void insterObject() {
        try {
            Connection connection = JDBCUntil.getConnection();
            //Statement statement = connection.createStatement();
            //参数化查询
           //statement.executeUpdate("INSERT INTO student VALUES (?,?,?,NULL ");
            PreparedStatement p= connection.prepareStatement("INSERT INTO student VALUES (?,?,?,NULL )");
            p.setString(1, "慕容小仙ss");
            p.setInt(2, 18);
            p.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
           if(p.executeUpdate()>0)
           {
               System.out.println("新增成功");
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
