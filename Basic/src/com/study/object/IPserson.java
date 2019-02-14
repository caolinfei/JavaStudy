package com.study.object;
/*
* java 接口中只可以定义方法 和静态字段
*重写不可以重写final方法
*
* 静态方法隐藏 public static  String getPersonNameStatic()
    {
        return  "staticPerson";
    }
*
* */
public   interface IPserson {

        void  sayHello();

}
