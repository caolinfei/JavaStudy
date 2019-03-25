package com.test.dao;

import com.test.domain.User;
import com.test.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {


    private final JdbcTemplate template = new JdbcTemplate(JDBCUtil.getdDataSource());

    /**
     * 获取用户信息
     *
     * @param userName 用户名
     * @param pwd      密码
     * @return 用户信息
     */
    public User getUser(String userName, String pwd) {


        try {
            User user = template.queryForObject("select * from tb_user where username=? and password=?",
                    new BeanPropertyRowMapper<User>(User.class),
                    userName, pwd);

            return user;
    }
        catch (Exception e){
            //e.printStackTrace();
            return  null;
        }


    }
}
