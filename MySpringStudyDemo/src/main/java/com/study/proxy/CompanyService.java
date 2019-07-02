package com.study.proxy;

/**
 * @Author: caolf
 * @Date: 2019/7/2 15:32
 */
public class CompanyService implements  ICompany {

    public void sale(double money) {
        System.out.println("企业售卖得到:"+money);
    }
}
