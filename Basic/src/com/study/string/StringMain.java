package com.study.string;

import java.util.Objects;

public class StringMain {
    public static void main(String[] args) {


//        String s=new String("12345678");//new出来的string类是分配在堆上的
//s.intern();
//        String s1="12345678";//直接"123"的长量分配在常量池中
//        String s2="12345678";
//        String s3="12345"+"678";
//
//        System.out.println(s==s1);//false//分配在常量池中的 直接拿来用 所以指向同一个引用
//        System.out.println(s1==s2);//true
//
//        System.out.println(s1==s3);
//
//        System.out.println(s2==s.intern());

//        String s3 = new String("bb");
//        s3=s3.intern();//这里必须重新赋值才行
//        String s4 = "bb";
//
//        System.out.println(s3 == s4);
//
//        String s="asda";
//        s+="213";
//
//        StringBuilder sb=new StringBuilder();
//        sb.toString();
//        //s.equals("123");
//        String s1=new String("he")+new String("llo"); //第二句
//        s1.intern();   //将 堆中新建的对象"hello" 存入字符串常量池
//        String s2="hello";  //第三句
//        System.out.println(s1==s2);//输出是true。
//
//        String s3=new String("hello");
//        s3.intern();
//        String s4="hello";
//        System.out.println(s3==s4);//输出false

        String s="aa"+"bb"+"cc"+"dd";//编译器会优化成 aabbccdd 不会常量池只有这个字符串

        s+="ee";//调用build然后tostring
        String s1 = new String("abc");
        s1.intern();

        //比较字符串的时候 如果空指针的时候 可以使用Objects
        Objects.equals(null,null);//支持为null的判断 工具类
    }




}
