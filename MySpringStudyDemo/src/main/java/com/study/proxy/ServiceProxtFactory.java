package com.study.proxy;

import com.mchange.v1.util.ArrayUtils;
import com.study.annotation.Transaction;
import com.study.dao.utils.TransactionManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: caolf
 * @Date: 2019/7/3 10:01
 */
@Component
public class ServiceProxtFactory<TService> {

    public void setService(TService service) {
        this.service = service;
    }

    public TService service;


    @Autowired
    private TransactionManage transactionManage;

    public TService getService() {
        return (TService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Method[] declaredMethods = service.getClass().getDeclaredMethods();
                for (Method declaredMethod : declaredMethods) {
                    if (declaredMethod.getName().equals(method.getName()) ) {
                        if (declaredMethod.getAnnotation(Transaction.class) != null) {
                            try {
                                transactionManage.beignTranscation();
                                Object result = method.invoke(service, args);
                                transactionManage.commit();
                                return  result;
                            } catch (Exception e) {
                                transactionManage.rollback();
                                throw new RuntimeException(e);

                            } finally {

                                transactionManage.close();
                            }

                        }
                    }
                }

                return method.invoke(service, args);
            }
        });
        //transactionManage.beignTranscation();

    }
}
