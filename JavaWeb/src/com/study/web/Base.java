package com.study.web;

import java.lang.reflect.InvocationTargetException;

public class Base {

    public Base(){
        System.out.println(this.getClass());

        try {
            Object hello = this.getClass().getMethod("hello").invoke(this);
            System.out.println(hello);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
