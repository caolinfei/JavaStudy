package com.study;

public class InstanceFactory {
    public MyAccountServiceImpl createAccountSeviceImpl(){
        return new MyAccountServiceImpl();
    }
}
