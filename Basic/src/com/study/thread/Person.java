package com.study.thread;

import java.util.Calendar;

public class Person {

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private int age;

    public void Say() {

        System.out.println(String.format("my name %s 今天",name));
        System.out.println(Calendar.getInstance().getTime());
    }
}
