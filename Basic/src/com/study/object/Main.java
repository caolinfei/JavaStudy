package com.study.object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;

import static com.study.object.IPerson2.SayHello;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //Person p=new Student();

        //byte b=123;
        //p.sayHello();
//        System.out.println(p.getPersonName());
////        System.out.println(p.getPersonNameStatic());
//       final  String  s1=new String("123");
//       final  String  s2=new String("123");

       // System.out.println(s1==s2);

//        double d=1.7976931348623157;
//              d+=0.0000000000000000123;
//        System.out.println(d);


//        System.out.println(SayHello("sayhello"));
////
////        String s="123";
////
////        String out="asdasdsa"+s;
////        System.out.println(out);
////        StringBuffer sb=new StringBuffer();
////
////        sb.append("123");
////        System.out.println(sb.toString());

        File f= new File("d:/LOL.exe");


            out.println("试图打开 d:/LOL.exe");
            try {
                new FileInputStream(f);
                out.println("成功打开");
            }
            catch (Exception e){
                throw  e;
                //System.out.println(e.getMessage()+e);

                //e.printStackTrace();
            }


    }
}
