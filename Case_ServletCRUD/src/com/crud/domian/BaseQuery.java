package com.crud.domian;

public class BaseQuery<TEntity extends BaseEntity> {


    public Class getaClass() {
        return aClass;
    }


    private Class aClass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    protected Integer id;

    public BaseQuery(TEntity tEntity){
        this.aClass=tEntity.getClass();
    }

}
