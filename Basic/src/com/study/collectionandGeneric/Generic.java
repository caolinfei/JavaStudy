package com.study.collectionandGeneric;

import javax.management.Query;

public class Generic<Entity> {

    public static void main(String[] args) {

        GenericClass<String> genericClass=new GenericClass<>();
        genericClass.setModel("123");
        genericClass.Show("e");
        genericClass.Show();

    }



}

