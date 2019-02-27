package com.study.InnerClass;

import java.security.PublicKey;

public class Car {




    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private int num;

    public  int age;
     class Engin {

        public void ShowName() {

            int nums=12;
            //nums=13;Variable 'nums' is accessed from within inner class, needs to be final or effectively final 如果这里nums值改变 会报这个错 必须是有效final的
            class Say {

                public  void  show()
                {
                    System.out.println(nums);
                }
            }

            Say s = new Say();
            System.out.println( s.getClass().getName());
        }

    }
}
