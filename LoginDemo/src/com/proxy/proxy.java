package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxy {

    public static void main(String[] args) {

        Computer computer=new Lenveo();

        Computer o = (Computer)Proxy.newProxyInstance(computer.getClass().getClassLoader(), computer.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //T annotation = method.getAnnotation(this.getClass());
                System.out.println(proxy.getClass());
                return method.invoke(computer, args);

            }
        });
        System.out.println(o.getClass().getInterfaces()[0].getName());
        System.out.println(o.getClass());
        String sale = o.sale(800);
        System.out.println(sale);



    }
}
