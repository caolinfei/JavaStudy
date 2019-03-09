package com.study.thread;

import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {

    private int count = 100;

    private Object o = new Object();

    private ReentrantLock lock=new ReentrantLock();
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public  void run() {
        //线程同步
        while (true) {
            System.out.println(Thread.currentThread().getName()+Thread.currentThread().getState());
            lock.lock();
           // synchronized (o) {
                if (count > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在卖" + count--);
                }
                lock.unlock();
                if(count==0)
                {
                    break;

                }
            }

        //}
    }
}
