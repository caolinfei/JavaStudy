package com.ui;

import com.study.MyAccountService;
import com.study.MyAccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class main {
    public static void main(String[] args) {

        /*
         *
         * Spring XML的几种加载方式:
         *       1:ClassPathXmlApplicationContext 使用Resource下文件加载 它是从类的根路径下加载配置文件
         *       2:FileSystemXmlApplicationContext 使用的是当前电脑的根路径
         *       3:Annotation的方式 (视频未看)
         * BeanFactory和ApplicationContext的区别
         *       1:BeanFactory 是对象需要的时候才实例化  BeanFactory factory=new XmlBeanFactory( new ClassPathResource("bean.xml")
         *                       XmlBeanFactory已经是过时的方法了
         *       2:ApplicationContext 在加载Bean.XML的时候就把对象实例化
         *
         * */

        ApplicationContext context =new FileSystemXmlApplicationContext("C:\\Users\\Administrator\\Desktop\\bean.xml");
        //ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        MyAccountService accountService = context.getBean("accountService", MyAccountService.class);

        for (int i = 0; i < 5; i++) {
            accountService=context.getBean("accountService",MyAccountService.class);
        System.out.println(accountService);
    }
        // 使用BeanFactory创建
//        BeanFactory factory=new XmlBeanFactory( new ClassPathResource("bean.xml")
//        );
//        MyAccountService accountService = factory.getBean("accountService", MyAccountService.class);
        accountService.SayHello();
    }
}
