package com.study.thread;

public class MyNotifyTest {
    public static void main(String[] args) {


        XiaoJi xiaoJi=new XiaoJi();

        Thread laoYing=new LaoYing(xiaoJi);

        Thread nongfu=new NongFu(xiaoJi);
        laoYing.start();
        nongfu.start();


    }
}

class XiaoJi {
    boolean Flag;
    String name;

}

class LaoYing extends Thread {
    private XiaoJi xiaoJi;

    public LaoYing(XiaoJi xiaoJi) {
        this.xiaoJi = xiaoJi;
    }

    @Override
    public void run() {
        //while (true) {

            System.out.println("老鹰是否会再次执行");
            synchronized (xiaoJi) {
                if (xiaoJi.Flag == false) {
                    try {
                        System.out.println("进入老鹰false的判断");
                        xiaoJi.wait();
                        System.out.println("进入老鹰false的判断wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                xiaoJi.Flag=false;
                xiaoJi.notify();
                System.out.println("老鹰把小鸡吃了");
           // }


        }
    }
}

class NongFu extends Thread {
    XiaoJi xiaoJi;

    public NongFu(XiaoJi xiaoJi) {
        this.xiaoJi = xiaoJi;
    }

    @Override
    public void run() {
        synchronized (xiaoJi) {
             int count =1;
           // while (true) {
                if (xiaoJi.Flag == true)//有小鸡在 不释放 等待小鸡消失
                {
                    try {
                        xiaoJi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            System.out.println("wait后执行");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                xiaoJi.Flag=true;
                xiaoJi.notify();
                System.out.println("释放一只小鸡 这是第" +count++);
            //}


        }


    }
}
