package com.study.InnerClass;

public class Main {

    public static void main(String[] args) {

        //1创建一个外部类
        Car c=new Car();
        Car.Engin engin=c.new Engin();
        //使用内部类的时候 必须要外部类名.
        //Car.Engin e=new Car().new Engin();
        engin.ShowName();//showname为局部内部类的方法 局部内部类是方法内部的类
        //当只要使用一次的时候 可以使用匿名内部类来实现一个接口
        IFly f=new IFly() {
            @Override
            public void Fly() {
                System.out.println("匿名内部类");
            }
        };
        f.Fly();
    }
}
