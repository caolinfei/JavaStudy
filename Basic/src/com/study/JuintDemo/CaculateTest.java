package com.study.JuintDemo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CaculateTest {

    @Before
    public void Before() {
        System.out.println("总是第一个执行的");
    }

    @Test
    public void TestSum() throws Exception {
        Caculate caculate = new Caculate();
        int sum = caculate.Sum(1, 3);
        Assert.assertEquals(8, sum);
    }

    @After
    public void After() {
        System.out.println("总是最后一个执行的");
    }
}
