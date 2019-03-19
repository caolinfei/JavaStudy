package com.study.jdbcConnectionPool;

public class exception {

    public   void method1() throws Exception {
        method2();
    }

    private void method2() throws Exception {

        method3();
    }

    private void method3() throws Exception {
        throw new Exception("method3");
    }
}
