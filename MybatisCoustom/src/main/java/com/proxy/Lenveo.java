package com.proxy;

public class Lenveo implements Computer {
    private String s1="123";

    @Override
    public String sale(double money) {
        System.out.println("卖电脑了");
       return money+"元卖了一台电脑";
    }
}
