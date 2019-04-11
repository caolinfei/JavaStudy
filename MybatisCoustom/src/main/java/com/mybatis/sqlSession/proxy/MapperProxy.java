package com.mybatis.sqlSession.proxy;

import com.mybatis.cfg.Mapper;
import com.mybatis.untils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    private Map<String, Mapper> mappers;
    private Connection connection;
    public MapperProxy(Map<String,Mapper> mappers,Connection conn){
        this.mappers = mappers;
        this.connection = conn;
    }


    /**
     *
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String methodName = method.getName();

        String className = method.getDeclaringClass().getName();
        String fullName=className+'.'+methodName;
        Mapper mapper = mappers.get(fullName);
        if(mapper==null){
            throw  new IllegalArgumentException("参数异常");
        }

      return new Executor().selectList(mapper,connection);



    }
}
