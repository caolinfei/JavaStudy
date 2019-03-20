package com.study.serviceLoadTest;

public class ShowMessage implements  MessageService {
    static {
        System.out.println("被加载的时候直接创建了实例");
    }

    public ShowMessage(){
        System.out.println("默认的构造函数被执行了");
    }
}
