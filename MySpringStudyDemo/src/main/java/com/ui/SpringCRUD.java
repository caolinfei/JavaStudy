package com.ui;

import com.study.domain.Account;
import com.study.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringCRUD {


    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean02.xml");

       IAccountService accountService = context.getBean("accountService", IAccountService.class);
        List<Account> all = accountService.findAll();
        System.out.println(all);
        //accountService=null;
        //PreDestroy执行
        //context.close();
        //重新加载Spring容器
        //context.refresh();


        //使用dbUtils完成增删改查


    }
}
