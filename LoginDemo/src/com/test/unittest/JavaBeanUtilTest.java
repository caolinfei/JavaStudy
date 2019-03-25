package com.test.unittest;

import com.test.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class JavaBeanUtilTest {

    @Test
    public void  Test(){

        User user =new User();
        try {
            String userName = BeanUtils.getProperty(user, "userName");
            System.out.println("userName");
            BeanUtils.setProperty(user,"userName","张三");
            System.out.println(user.getUserName());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
