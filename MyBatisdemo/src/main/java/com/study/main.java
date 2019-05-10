package com.study;

import com.study.domian.Account;
import com.study.domian.UserAccount;
import org.apache.log4j.lf5.util.ResourceUtils;

import java.util.*;

public class main {

    public static void main(String[] args) {
//        BaseRespsitory<UserAccount> baseRespsitory=new BaseRespsitory();
//        BaseRespsitory<Account> accountBaseRespsitory=new BaseRespsitory();
//        baseRespsitory.toString();
//        accountBaseRespsitory.toString();
//        System.out.println(13);
        //List<String>[] ls = new ArrayList<String>[10];
        //ArrayList<Integer>[] as=new ArrayList<Integer>[];

//        ArrayList<String>[] lsa = new ArrayList[10];//new List<String>[10]; // Not really allowed.
//        lsa[0]=new ArrayList<String>();
//        //Class<? extends ArrayList> aClass = lsa[0].getClass();
//        Object o = lsa;
//        Object[] oa = (Object[]) o;
//        List<Integer> li = new ArrayList<Integer>();
//        li.add(new Integer(3));
//        oa[1] = li; // Unsound, but passes run time store check
//        String s = lsa[1].get(0); // Run-time error: ClassCastException.
//       //lsa[0]=new ArrayList<Integer>();


//        List<Integer>[] genericArray = (List<Integer>[])new ArrayList[10];
//        genericArray[0] = new ArrayList<String>(Arrays.asList(new String[]{"Hello"}));
        //编译看左 运行看右
//        Object[] ducks=new Integer[10];
//        ducks[0]="123";
//
//        Integer[] ints = new Integer[10];
//
//        Object[] o = ints;
//        o[0] = "hello";

        Base b=new ZI1();
        b.show("123");

    }
}
