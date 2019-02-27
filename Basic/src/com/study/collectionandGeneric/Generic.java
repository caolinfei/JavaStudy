package com.study.collectionandGeneric;

public class Generic {

    public static void main(String[] args) {

        GenericClass<String> genericClass=new GenericClass<>();
        genericClass.setModel("123");
        genericClass.Show("e");
        genericClass.Show();
        ShowGeneric(123);
    }
    //generic method

    public static  <E> void  ShowGeneric(E e)
    {
        System.out.println(e);
    }
}
