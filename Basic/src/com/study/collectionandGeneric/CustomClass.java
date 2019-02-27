package com.study.collectionandGeneric;

public class CustomClass {


    public String name ;

    public CustomClass(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 1; //this.name.hashCode();
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
