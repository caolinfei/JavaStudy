package com.study;

import java.util.*;

public class MyAccountServiceImpl implements MyAccountService {
   private List<String> strings;
   private Set<String> sets;
   private Map<String,String> map;

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private Properties properties;


    private  int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public Date brithday;
    public MyAccountServiceImpl() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  String name;
    public MyAccountServiceImpl(int age,String name){
//         this.age=age;
//         this.name=name;
        //System.out.println("初始化Bean的十几家加载了");
        System.out.println(getName()+"======"+getAge());
    }

    @Override
    public String toString() {
        return "MyAccountServiceImpl{" +
                "strings=" + strings +
                ", sets=" + sets +
                ", map=" + map +
                ", properties=" + properties +
                ", age=" + age +
                ", brithday=" + brithday +
                ", name='" + name + '\'' +
                '}';
    }

    public void SayHello() {
        System.out.println("Hello Spring");
    }
}
