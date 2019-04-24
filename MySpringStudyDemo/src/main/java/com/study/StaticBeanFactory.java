package com.study;

public class StaticBeanFactory {

    public static MyAccountServiceImpl createAccountSeviceImpl(){
        return new MyAccountServiceImpl();
    }
}
