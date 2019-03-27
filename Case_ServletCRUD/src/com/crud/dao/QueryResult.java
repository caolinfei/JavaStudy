package com.crud.dao;

import com.crud.domian.BaseEntity;

import java.util.List;

public class QueryResult<TEntity extends BaseEntity> {

    private List<TEntity> list;

    public List<TEntity> getList() {
        return list;
    }

    public void setList(List<TEntity> list) {
        this.list = list;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    private int cout;

}
