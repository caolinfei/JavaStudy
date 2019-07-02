package com.study.proxy;

/**
 * @Author: caolf
 * @Date: 2019/7/2 15:34
 */
public class StaticProxyService implements ICompany {
    CompanyService companyService=new CompanyService();
    public void sale(double money) {
        System.out.println("顾客给的钱"+money);
        money=money*0.8;
        companyService.sale(money);
        System.out.println("拿走货物");
    }
}
