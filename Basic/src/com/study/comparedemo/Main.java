package com.study.comparedemo;

public class Main {
    public static void main(String[] args) {


        Main.Demo d=new Main().new Demo();


    }

    public class Demo implements  Comparable<Demo>
    {
        private int getAge() {
            return Age;
        }

        public void setAge(int age) {
            Age = age;
        }

        public int Age ;


        @Override
        public int compareTo(Demo o) {
            if(o.getAge()>this.Age)
            {

            }
            return 0;
        }
    }
}
