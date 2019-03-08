package com.study.thread;
/**
 *
 * hello
 *
 * */
public class MyThread extends Thread {

    private int age ;

    public MyThread(int age, String name) {
        this.age = age;
        this.name = name;
        System.out.println("初始化"+age+"======"+name);
    }

    private String name;
    @Override
    public void run() {
        //Student student = Student.getInstance();
        Student.getInstance().setName(name);
        Student.getInstance().setAge(age);
        Student.getInstance().toString();
    }
}
