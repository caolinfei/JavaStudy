package com.ui;

import com.study.domain.Account;
import com.study.proxy.ServiceProxtFactory;
import com.study.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SpringCRUD {


    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean02.xml");

        IAccountService accountService = context.getBean("accountService", IAccountService.class);
        //List<Account> all = accountService.findAll();
        //System.out.println(all);
//        ServiceProxtFactory<IAccountService> serviceProxtFactory = context.getBean("serviceProxtFactory", ServiceProxtFactory.class);
       // serviceProxtFactory.setService(accountService);


        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 2; i++) {
            executorService.execute(()->{
                accountService.transfer2();

            });
        }
//        Thread t=new Thread(()->{
//
////            serviceProxtFactory.getService().transfer(1,2,new BigDecimal(200));
//            System.out.println(Thread.currentThread().getId());
//            accountService.transfer2();
//        });
//        t.start();

       /* Thread t2=new Thread(()->{
            System.out.println(Thread.currentThread().getId());
//         serviceProxtFactory.getService().transfer(1,2,new BigDecimal(200));
            accountService.transfer2();
        });
        t2.start();*/




        }

    }

