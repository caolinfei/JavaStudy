package com.ui;

import com.study.MyAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

    /*


     */
    public static void main(String[] args) {

        /*
         *  Day_01
         * Spring XML的几种加载方式:
         *       1:ClassPathXmlApplicationContext 使用Resource下文件加载 它是从类的根路径下加载配置文件
         *       2:FileSystemXmlApplicationContext 使用的是当前电脑的根路径
         *       3:Annotation的方式 基于注解的方式配置
         * BeanFactory和ApplicationContext的区别
         *       1:BeanFactory 是对象需要的时候才实例化  BeanFactory factory=new XmlBeanFactory( new ClassPathResource("beanday01.xml")
         *                       XmlBeanFactory已经是过时的方法了
         *       2:ApplicationContext 在加载Bean.XML的时候就把对象实例化 一次性将所有的对象都实例化
         *
         * Bean的细节以及实例化三种ben的范式见Bean.xml
         *
         * Spring的依赖注入
         *      构造函数注入:
         *                      在bean标签下使用 constructor-arg name="name" value=" 张三 "></constructor-arg>
         *                  如果是基本类型 直接赋值 如果是其他bean对象则需要ref 指向已经配置的bean的Id
         *      set属性注入
         *          bean 文本内容里配置Property
         *      p标签的配置方式
         *           xmlns:p="http://www.springframework.org/schema/p"
         *           在bean标签的内部填写 p:name="" ref 支持引用类型
         *           需要直接指向一个bean对象
         * */

        //ApplicationContext context =new FileSystemXmlApplicationContext("C:\\Users\\Administrator\\Desktop\\beanday01.xml");
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:beanday01.xml");
        MyAccountService accountService = context.getBean("accountService", MyAccountService.class);

        //  默认创建的是单列的
//        for (int i = 0; i < 5; i++) {
//            accountService=context.getBean("accountService",MyAccountService.class);
//            System.out.println(accountService);
//    }
        accountService=context.getBean("accountService",MyAccountService.class);

        System.out.println(accountService.toString());
        // 使用BeanFactory创建
//        BeanFactory factory=new XmlBeanFactory( new ClassPathResource("beanday01.xml")
//        );
//        MyAccountService accountService = factory.getBean("accountService", MyAccountService.class);
        //accountService.SayHello();
    }
}
