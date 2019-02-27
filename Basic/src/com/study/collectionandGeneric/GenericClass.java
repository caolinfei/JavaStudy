package com.study.collectionandGeneric;

import javax.jws.WebParam;

public class GenericClass<E> {


    public E getModel() {
        return Model;
    }

    public void setModel(E model) {
        Model = model;
    }

    public  E Model ;
    public  void  Show(E e)
    {
        System.out.println(e);
    }

    public void Show()
    {
        System.out.println(Model);
    }
}
