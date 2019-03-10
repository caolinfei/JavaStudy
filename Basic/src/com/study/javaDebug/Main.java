package com.study.javaDebug;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
/*
        System.out.println("+++++++++++++++++++++++++++++");
        Test.Say();
        Test1.Say();*/
        Thread thread = new MyThread();
        thread.start();
    }
}

class Test {

    public static void Say() {
        System.out.println("say");
    }
}

class Test1 {
    public static void Say() {
        System.out.println("say1");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("多线程调试");

        MyRunnable runnable=new MyRunnable();
        Thread thread=new Thread(runnable,"线程1");
        Thread thread1=new Thread(runnable,"线程2");
        Thread thread2=new Thread(runnable,"线程3");
    }
}

 class MyRunnable implements Runnable {

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + "-------------进入");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(currentThread.getName() + "-------------离开");
        }

    }
}

