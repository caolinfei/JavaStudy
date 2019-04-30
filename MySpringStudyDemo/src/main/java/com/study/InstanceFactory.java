package com.study;

public class InstanceFactory {
    public MyAccountServiceImpl createAccountSeviceImpl(){
        return new MyAccountServiceImpl(123,"张三hello");
    }
}
