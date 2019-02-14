package com.study.object;
/*
* 父类中没有默认的构造函数 要么指定调用哪个 和C#其实一样
* */
public class Student extends Person implements IPserson, IPerson2 {


    public Student(int age)
    {
       super(age);
    }
    @Override
    public void sayHello() {
        System.out.printf("hello");
    }

    @Override
    public String getPersonName() {
        return "Student";
    }

    public static  String getPersonNameStatic()
    {
        return  "staticStudent";
    }

    private int age ;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    private int sex;
}
