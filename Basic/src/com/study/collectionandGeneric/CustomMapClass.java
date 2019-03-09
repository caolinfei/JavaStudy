package com.study.collectionandGeneric;

public class CustomMapClass {

    private String name ;

    public CustomMapClass(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        return 123;
    }

    @Override
    public String toString() {
        return this.name;
    }


}
