package com.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Lenveo lenveo = new Lenveo();
      if("toString".equals(method.getName())){
          return "ToString";
      }
        method.invoke(lenveo, args);
        return null;
    }
}
