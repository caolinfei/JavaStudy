package com.study.object;

import java.security.PrivateKey;

public interface IPerson2 {

    static String SayHello(String s) {
        return s;
    }

    default  void defaltMeath(String s){
        System.out.println(s);
    }

}
