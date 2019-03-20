package com.study.jdbcConnectionPool;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.study.until.JDBCUntilsForJDBCTempLate;
import org.springframework.jdbc.core.JdbcTemplate;


public class jdbctemplateDemo {
    public static void main(String[] args) {

        JdbcTemplate template = new JdbcTemplate(JDBCUntilsForJDBCTempLate.dataSource);
        int affected = template.update("update student set name=? where id=?", "untils", 3);
        if (affected > 0) {
            System.out.println("成功");
        }


    }
}
