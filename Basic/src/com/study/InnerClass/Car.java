package com.study.InnerClass;

import java.security.PublicKey;

public class Car {


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private int num;

    public  int age;
    public class Engin {

        public void ShowName() {

            class Say {

            }

            Say s = new Say();
            s.getClass().getName();
        }

    }
}
