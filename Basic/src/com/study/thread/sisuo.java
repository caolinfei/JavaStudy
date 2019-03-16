package com.study.thread;
@SuppressWarnings("all")
public class sisuo {

    public static  String s1="筷子左";
    public static  String s2="筷子右";
    public static void main(String[] args) {
        /**
         * 演示死锁
         * */

        Thread t1=new Thread(){
            @Override
            public void run() {
                while (true)
                {
                    synchronized (s1)
                    {
                        System.out.println("线程A拿到了"+s1);
                        synchronized (s2)
                        {
                            System.out.println("线程A拿到了"+s2);
                        }
                    }
                }
            }
        };


        Thread t2=new Thread(){
            @Override
            public void run() {
                while (true)
                {
                    synchronized (s2)
                    {
                        System.out.println("线程B拿到了"+s2);
                        synchronized (s1)
                        {
                            System.out.println("线程B拿到了"+s1);
                        }
                    }
                }
            }
        };
        t1.start();
        t2.start();
        /**
         * 最总死锁的原因是  线程A拿到了筷子左 线程B拿到了筷子右  分析上述代码  当t1锁住了s1的时候
         * 如果线程b抢占了资源 执行 同步代码块 sync(s2)的时候 如果下一轮线程的争抢 s2没有枪果s1
         * 这个时候 线程1占有了s1 要去锁s2 而线程2占有了s2要去锁s1冲突就发生了 他们在互相等待对方释放自己所占有的锁
         * 那么此时就无限等待了 也就是死锁的发生
         * */
    }
}
