package com.study;

public class MyAccountServiceImpl implements MyAccountService {
    public MyAccountServiceImpl(){
        //System.out.println("初始化Bean的十几家加载了");
    }

    public void SayHello() {
        System.out.println("Hello Spring");
    }
}
