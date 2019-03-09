package com.study.thread;

public class Student {
/*
* @description单例模式下 成员变量都会线程安全问题
* */
    public static Student getInstance() {
        if (instance == null) {
            synchronized (Student.class) {
                if (instance == null) {
                    instance = new Student();
                }
            }
        }
        return instance;
    }

    private static Student instance;
    private String name;
    private long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    @Override
    public String toString() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(age+"="+name);
        return "";
    }
}
