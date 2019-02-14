package com.study.object;

import java.util.ArrayList;

public final class Ad {
    public String name;
    protected float hp;
    private static int count;

    public String toString(){
        return name;
    }
    @Override
    public void finalize(){
        System.out.println("这个英雄正在被回收"+count++);
    }

    public static void main(String[] args)  {
        //只有一引用
        ArrayList a=new ArrayList();
        Ad h;
        for (int i = 0; i < 100000; i++) {

            for (int i1 = 0; i1 < 1000; i1++) {
                a.add("123123213");
            }

            //不断生成新的对象
            //每创建一个对象，前一个对象，就没有引用指向了
            //那些对象，就满足垃圾回收的条件
            //当，垃圾堆积的比较多的时候，就会触发垃圾回收
            //一旦这个对象被回收，它的finalize()方法就会被调用
            h = new Ad();
        }

    }
}