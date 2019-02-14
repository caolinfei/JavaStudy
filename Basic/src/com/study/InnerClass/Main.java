package com.study.InnerClass;

public class Main {

    public static void main(String[] args) {
        //Car.Engin e=new Car().new Engin();
        IFly f=new IFly() {
            @Override
            public void Fly() {
                System.out.println("匿名内部类");
            }
        };
    }
}
