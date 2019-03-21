package com.study.templatetest;

import com.study.entity.Student;
import com.study.until.JDBCUntil;
import com.study.until.JDBCUntilsForJDBCTempLate;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TemplateDemo {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUntilsForJDBCTempLate.dataSource);


    @Test
    public void TestQuery() {

        RowMapper<Student> rowMapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setName(resultSet.getString("name"));
                student.setId(resultSet.getInt("id"));
                return student;
            }
        };
        List<Student> query = jdbcTemplate.query("select * from student", rowMapper);
        System.out.println(query);
    }

    @Test
    public void TestTran() {
        Connection connection = null;
        try {
            //jdbctemplate 想要事务的还是要获取原来的connection不知道是否有其他的办法
            connection = jdbcTemplate.getDataSource().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("update student set  name='tranException' where id=?");
            preparedStatement.setInt(1, 1);
            PreparedStatement preparedStatement1 = connection.prepareStatement("update student set name ='tranException1' where id=?");
            preparedStatement1.setInt(1, 2);
            preparedStatement.executeUpdate();
            int i = 1 / 0;
            preparedStatement1.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void queryss() {

        //getName 写错了 其实就相当于C#中的属性错了  反射 找到当前字段的 getset方法 然后执行这个方法 因为写错了 找不到
        // 所以.......就有问题了
        List<Student> query = jdbcTemplate.query("select * from student where id=1", new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println(query);
    }
}
