package com.study.dao.utils;

import org.aspectj.lang.ProceedingJoinPoint;
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
     * 回滚事务
     */
    public void rollback() {
        try {
            connectionUtils.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接
     */
    public void close() {
        try {
            System.out.println("释放连接");
            //dataSource 关闭连接 还回连接池
            connectionUtils.getConnection().close();
            //这里如果不释放的话 会空指针异常
            //Connection 连接池对象内部封装了一个Jdbc4Connection对象 连接数据就是这个,
            //所以当ThreadLocal不进行Remove的时候 Connection存在 但是内部的Jdbc4Connection
            connectionUtils.removeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Object around(ProceedingJoinPoint proceedingJoinPoint) {


        Object result = null;
        try {
            beignTranscation();
            result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
            commit();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            rollback();
            throw new RuntimeException(throwable);
        } finally {
            close();
        }
        return result;
    }
}
