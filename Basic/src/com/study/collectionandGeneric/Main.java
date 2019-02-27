package com.study.collectionandGeneric;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //集合的迭代器  list extends collectionandGeneric imp iterator
        //迭代器的类型取决于泛型的类型
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            list.add(i + "");
//        }
//        String[] strings = new String[]{};//java中没有索引器


//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext())
//        {
//            System.out.println(iterator.next());
//        }

        //增强for 其实就是foreach

//        for (String s : list) {
//            System.out.println(s);
//        }

        //lambada
       /* list.forEach(m->{
            System.out.println(m);
        });*/

        //Queue<String> queue=new LinkedList<>();
//        LinkedList<String> list1 = new LinkedList<>();
//
//        list1.add("5");
//        list1.add("4");
//        list1.add("3");
//        list1.add("1");
//        list1.add("aac");
//
//        System.out.println(list1);
//        System.out.println(list1.pop());
//        list1.push("8");//addFirst 实现了双端队列 先进的先出
//        System.out.println(list1);
//        list.get(1);
//
       HashSet<CustomClass> set = new HashSet<>();//内部是使用了HashMap实现的 只不过key是一个常量
        //采用的是hash表+数组+链表 当链表长度大于8改为红黑树
        //hashset无序

        ///使用hashset 保存自定义的类型 要重写hashcode 因为不同对象的hashcode是不同的 自定义hashcode的比较方法这样就能保证不唯一 比如 以id.hashcode 或者 姓名 身份证号hashcode
        //如果每次hashcode都是返回同一个值 那么以下会存储在同一个链表/红黑树内会顺序打印
        //如果每次hashcode不一样那么会按照一定的算法 整除取余 计算应该存在表内的哪个索引处
        //然后再Equals 比较是不是同一个对象 ==比较
      set.add(new CustomClass("b"));
      set.add(new CustomClass("a"));
      set.add(new CustomClass("d"));
      set.add(new CustomClass("c"));
      set.add(new CustomClass("e"));


        System.out.println(set);
        //使用链表来维护顺序 其底层是使用linkedHashMap实现的 HasMap<e,object>其中objetc为一个常量
        /*LinkedHashSet<CustomClass> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(new CustomClass("b"));
        linkedHashSet.add(new CustomClass("a"));
        linkedHashSet.add(new CustomClass("d"));
        linkedHashSet.add(new CustomClass("c"));
        linkedHashSet.add(new CustomClass("e"));
        //打印结果[b, a, d, c, e]
        System.out.println(linkedHashSet);
        //可变参数

        System.out.println(sum(1,3,3,4,56,1));
        System.out.println(sum(new int[]{1,2,3,4,5}));*/

        //Collections 集合工具类
        List<String> list=new ArrayList<>();
        Collections.addAll(list,new String[]{"3","2","8"});//添加一组元素或一个
        System.out.println(list);
        Collections.shuffle(list);//随机排序
        System.out.println(list);

        Collections.sort(list);//按照默认排序
        System.out.println(list);
        //自定义比较器
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               char c=o1.charAt(0);
               char c2=o2.charAt(0);
               return (c2-c);
            }
        });
        System.out.println(list);

    }


    public static int sum(int... arras)
    {
        int sums=0;
        for (int arra : arras) {
         sums+=arra;
        }
        return sums;
    }
}
