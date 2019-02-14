package com.study.string;

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

        String s3 = new String("bb");
        s3=s3.intern();//这里必须重新赋值才行
        String s4 = "bb";

        System.out.println(s3 == s4);


    }
}
