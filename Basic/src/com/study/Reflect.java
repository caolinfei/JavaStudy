package com.study;

import com.study.thread.Person;

import java.util.Calendar;
import java.util.Date;

/**
 * Java反射
 */
public class Reflect {

    /**
     * Main方法Calendar.getInstance().getTime()
     *
     * @param args
     */
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("张三");
        Calendar c = Calendar.getInstance();
        Date time = c.getTime();
        time.getTime();
        System.out.println(time.getTime());
        person.Say();

    }

}

