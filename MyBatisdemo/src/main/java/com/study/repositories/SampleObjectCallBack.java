package com.study.repositories;

import java.lang.reflect.ParameterizedType;

public abstract class SampleObjectCallBack<T> {

    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public SampleObjectCallBack() {
        System.out.println(this);
        //this 代表的是当前指向的对象 而不一定是当前SampleObjectCallBack base
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>) type.getActualTypeArguments()[0];
    }

    public abstract void onSuccess(T t);

    public abstract void onError(int error, String msg);

    public Class<T> getClazz() {
        return clazz;
    }

}
