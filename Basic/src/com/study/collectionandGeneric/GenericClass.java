package com.study.collectionandGeneric;

import javax.jws.WebParam;
import java.lang.reflect.Type;

public class GenericClass<E> {

    public  GenericClass()
    {
        Type genericSuperclass = eClass.getGenericSuperclass();
    }
    
    public  Class<E> eClass;

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
