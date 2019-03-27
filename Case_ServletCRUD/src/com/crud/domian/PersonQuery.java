package com.crud.domian;

import java.util.Map;

public class PersonQuery extends BaseQuery<Person> {

    private Integer id;
    private Boolean sex;
    private String name;

    public PersonQuery() {
        super(new Person());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
