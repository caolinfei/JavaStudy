package com.study.collectionandGeneric;

import java.util.*;
import java.util.Map.Entry;

public class MapDic {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();

        map.put("hello", "123");
        map.put("hello1", "123");
        map.put("hello2", "123");
        map.put("hello3", "123");
        map.put("hello4", "123");
        System.out.println(map);
        Set<Entry<String, String>> entries = map.entrySet();

        for (Entry<String, String> entry : entries) {

            System.out.println(entry.getKey() + "" + entry.getValue());
        }

        Set<String> strings = map.keySet();


        for (String string : strings) {

            System.out.println("key"+string+ "val"+map.get(string));
        }
        //System.out.println(map.entrySet());
        //map put如果不存在值直接存入返回null  如果存在直接替换返回原来的值
        HashMap<CustomMapClass, String> customMapClassStringHashMap = new HashMap<>();
        CustomMapClass c = new CustomMapClass("123");
        String put = customMapClassStringHashMap.put(new CustomMapClass("123"), "日本");
        System.out.println(put);
        //如果重新写了hashcode 和equals方法 比较的都是相同的 那么就会返回替换掉的值
        String put2 = customMapClassStringHashMap.put(new CustomMapClass("123"), "上海");
        customMapClassStringHashMap.put(new CustomMapClass("123"), "天津");
        System.out.println(put2);
        System.out.println(customMapClassStringHashMap);



    }
}
