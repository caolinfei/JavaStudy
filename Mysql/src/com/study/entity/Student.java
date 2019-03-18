package com.study.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Student {

    private String name;
    private int age;
    private Date date;
    private BigDecimal amoutn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id ;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmoutn() {
        return amoutn;
    }

    public void setAmoutn(BigDecimal amoutn) {
        this.amoutn = amoutn;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", amoutn=" + amoutn +
                ", id=" + id +
                '}';
    }
}

