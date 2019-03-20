package com.study.serviceLoadTest;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ServiceLoaderDemo01 {
    public static void main(String[] args) {
        //会紧挨着Meta-Inf下的services 文件下的文件 文件名 默认和类的全名称一致
        //文件里内容是实现了这个接口类的全名称
        //当被加载的时候 其实和Class.forName(""),一样 创建了当前类的实例
        ServiceLoader<MessageService> serviceLoader =
                ServiceLoader.load(MessageService.class);
        Iterator<MessageService> iterator = serviceLoader.iterator();
      while (iterator.hasNext())
      {
          MessageService next = iterator.next();
      }
        

    }
}
