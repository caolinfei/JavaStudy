package com.study.repositories;

import com.sun.prism.shader.FillPgram_RadialGradient_REFLECT_AlphaTest_Loader;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class Respsitory<T> {

    public  Respsitory(){}

    public  Respsitory(Class<? extends  Respsitory> tClass){

        this.extentClass=tClass;

    }
    private Class  extentClass;


    protected String buildSql() {

        Class<? extends Respsitory> aClass = this.getClass();

        System.out.println(extentClass.getName());
        return "";
    }


}
