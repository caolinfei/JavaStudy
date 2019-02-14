package com.study.object;

public class Person implements IPerson2 {

    public Person() {

    }
    public Person(int age) {
        this.name = "Person";
        System.out.println("父类执行五参数");
    }
    public Person(String s) {
        System.out.println("父类执行有参数"+s);
    }
    private String name;

    public  String getPersonName() {
        return this.name;
    }
    public static  String getPersonNameStatic()
    {
        return  "staticPerson";
    }
}
