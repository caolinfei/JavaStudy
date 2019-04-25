package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxy {

    public static void main(String[] args) {

        Computer computer=new Lenveo();

        Computer o = (Computer)Proxy.newProxyInstance(computer.getClass().getClassLoader(), computer.getClass().getInterfaces(), new MyInvocationHandler() {
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
        //如果只有一个接口没有实现类 直接代理接口
        //Computer computer= (Computer)Proxy.newProxyInstance(Computer.class.getClassLoader(), new Class[]{Computer.class}, new MyInvocationHandler());
//      Computer computer= (Computer)Proxy.newProxyInstance(Computer.class.getClassLoader(), new Class[]{Computer.class}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                Object s=this;
//              return   method.invoke(this,args);
//            }
//        });
        o.sale(123);


    }
}
