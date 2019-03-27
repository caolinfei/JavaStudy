package com.crud.domian;

public class BaseQuery<TEntity extends BaseEntity> {

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Integer getTake() {
        return take;
    }

    public void setTake(Integer take) {
        this.take = take;
    }

    private Integer skip;
    private Integer take;

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
