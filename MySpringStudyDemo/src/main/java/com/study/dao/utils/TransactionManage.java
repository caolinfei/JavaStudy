package com.study.dao.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @Author: caolf
 * @Date: 2019/7/3 9:23
 */
@Component
public class TransactionManage {
    @Autowired
    private ConnectionUtils connectionUtils;

    /**
     *
     * 开启事务支持 当前线程内取出连接 设置非自动提交事务
     */
    public void beignTranscation() {
        try {
            connectionUtils.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * 提交事务
     */
    public void commit() {
        try {
            connectionUtils.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *回滚事务
     *
     */
    public void rollback() {
        try {
            connectionUtils.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *关闭连接
     *
     */
    public void close() {
        try {
            //dataSource 关闭连接 还回连接池
            connectionUtils.getConnection().close();
            //
            ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
