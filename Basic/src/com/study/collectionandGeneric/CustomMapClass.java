package com.study.collectionandGeneric;

public class CustomMapClass {

    private String name ;

    public CustomMapClass(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 123;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode()==obj.hashCode();
    }
}
