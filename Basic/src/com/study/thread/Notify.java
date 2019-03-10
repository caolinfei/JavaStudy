package com.study.thread;

public class Notify {
    //等待与唤醒机制
    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();

        Thread baoZiPu = new BaoZiPu(baoZi);
        Thread chiHuo = new ChiHuo(baoZi);
        chiHuo.start();
        baoZiPu.start();


    }


}


class BaoZi {

    //默认不写default 可以在当前类内访问和同一个包内访问
    String pi;
    boolean flag;
    String xian;
}
/*
    生产者(包子铺)类:是一个线程类,可以继承Thread
	设置线程任务(run):生产包子
	对包子的状态进行判断
	true:有包子
		包子铺调用wait方法进入等待状态
	false:没有包子
		包子铺生产包子
		增加一些趣味性:交替生产两种包子
			有两种状态(i%2==0)
		包子铺生产好了包子
		修改包子的状态为true有
		唤醒吃货线程,让吃货线程吃包子

	注意:
	    包子铺线程和包子线程关系-->通信(互斥)
	    必须同时同步技术保证两个线程只能有一个在执行
	    锁对象必须保证唯一,可以使用包子对象作为锁对象
	    包子铺类和吃货的类就需要把包子对象作为参数传递进来
	        1.需要在成员位置创建一个包子变量
	        2.使用带参数构造方法,为这个包子变量赋值
 */
class BaoZiPu extends Thread {

    public BaoZiPu(BaoZi baoZi) {
        this.bz = baoZi;
    }

    private BaoZi bz;

    @Override
    public void run() {

        //定义一个变量
        int count = 0;
        //让包子铺一直生产包子
        // while (true) {
        //必须同时同步技术保证两个线程只能有一个在执行
        synchronized (bz) {
            //对包子的状态进行判断
            if (bz.flag == true) {
                //包子铺调用wait方法进入等待状态
                try {
                    bz.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("当前线程状态"+Thread.currentThread().getState());
            //被唤醒之后执行,包子铺生产包子
            //增加一些趣味性:交替生产两种包子
            if (count % 2 == 0) {
                //生产 薄皮三鲜馅包子
                bz.pi = "薄皮";
                bz.xian = "三鲜馅";
            } else {
                //生产 冰皮 牛肉大葱陷
                bz.pi = "冰皮";
                bz.xian = "牛肉大葱陷";

            }
            count++;
            System.out.println("包子铺正在生产:" + bz.pi + bz.xian + "包子");
            //生产包子需要3秒钟
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //包子铺生产好了包子
            //修改包子的状态为true有
            bz.flag = true;
            //唤醒吃货线程,让吃货线程吃包子
            bz.notify();
            System.out.println("包子铺已经生产好了:" + bz.pi + bz.xian + "包子,吃货可以开始吃了");
        }
        //}

    }
}

class ChiHuo extends Thread {
    //1.需要在成员位置创建一个包子变量
    private BaoZi bz;

    //2.使用带参数构造方法,为这个包子变量赋值
    public ChiHuo(BaoZi bz) {
        this.bz = bz;
    }

    //设置线程任务(run):吃包子
    @Override
    public void run() {
        //使用死循环,让吃货一直吃包子
        //while (true) {
        //必须同时同步技术保证两个线程只能有一个在执行
        synchronized (bz) {
            //对包子的状态进行判断
            if (bz.flag == false) {
                //吃货调用wait方法进入等待状态
                try {
                    bz.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("当前线程状态"+Thread.currentThread().getState());
            //被唤醒之后执行的代码,吃包子
            System.out.println("吃货正在吃:" + bz.pi + bz.xian + "的包子");
            //吃货吃完包子
            //修改包子的状态为false没有
            bz.flag = false;
            //吃货唤醒包子铺线程,生产包子
            bz.notify();
            System.out.println("吃货已经把:" + bz.pi + bz.xian + "的包子吃完了,包子铺开始生产包子");
            System.out.println("----------------------------------------------------");
        }
        //}
    }
}
