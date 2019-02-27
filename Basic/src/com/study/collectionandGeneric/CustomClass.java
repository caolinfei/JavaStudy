package com.study.collectionandGeneric;

public class CustomClass {


    public String name ;

    public CustomClass(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
