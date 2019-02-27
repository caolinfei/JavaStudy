package com.study.collectionandGeneric;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //集合的迭代器  list extends collectionandGeneric imp iterator
        //迭代器的类型取决于泛型的类型
        ArrayList<String> list=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i+"");
        }
        String[] strings=new String[]{};//java中没有索引器


//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext())
//        {
//            System.out.println(iterator.next());
//        }

        //增强for 其实就是foreach

        for (String s : list) {
            System.out.println(s);
        }

        //lambada
       /* list.forEach(m->{
            System.out.println(m);
        });*/

        Queue<String> queue=new LinkedList<>();
        LinkedList<String>  list1=new LinkedList<>();

        list1.add("5");
        list1.add("4");
        list1.add("3");
        list1.add("1");
        list1.add("aac");

        System.out.println(list1);

       list.get(1);

       HashSet<CustomClass> set=new HashSet<>();

      set.add(new CustomClass("b"));
      set.add(new CustomClass("a"));
      set.add(new CustomClass("d"));
      set.add(new CustomClass("c"));
      set.add(new CustomClass("e"));


        System.out.println(set);

    }
}
