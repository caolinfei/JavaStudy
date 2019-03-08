package com.study.thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //
       /* Student s=Student.getInstance();
        s.setName("main");
        s.setAge(1);

        //通过继承的方式使用多线程
        Thread t=new MyThread(2,"thread");
        t.start();
        Thread.sleep(1000);
        s.toString();*/

        //        for (int i = 0; i < 1000; i++) {
        //            Thread t=new MyThread(i,"循环"+i);
        //            t.start();
        //        }
        //    Thread thread=new Thread(new Runnable(){
        //
        //        @Override
        //        public void run() {
        //            System.out.println("runnable");
        //        }
        //    });
        //    thread.start();
        //
        //    }
        Ticket ticket=new Ticket();//
        Thread t1 = new Thread(ticket, "窗口1");
        Thread t2 = new Thread(ticket, "窗口2");
        Thread t3 = new Thread(ticket, "窗口3");
        System.out.println(t1.getState());
        System.out.println(t2.getState());
        System.out.println(t3.getState());
        t1.start();
        t2.start();
        t3.start();

        //线程同步的三种方式 synchronized(obj) synchronized标记方法  ReentrantLock
        //java中线程的状态
        //New Runnable Blocked Waiting(无限等待)  TeminatedWaiting  temiated


    }
}
