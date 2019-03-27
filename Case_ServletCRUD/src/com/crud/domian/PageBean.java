package com.crud.domian;

import com.crud.dao.QueryResult;

import java.util.List;

public class PageBean<TEntity> {
    private int totalPage;

    public boolean isHasNexPage() {
        return hasNexPage;
    }

    public boolean isHasPrePage() {
        return hasPrePage;
    }

    public void setQuery(BaseQuery query) {
        this.query = query;
    }

    public void setResult(QueryResult<TEntity> result) {
        this.result = result;
    }

    public PageBean(List<TEntity> result, int totalCount, Integer skip, Integer take){


    }


    private boolean hasNexPage;
    private boolean hasPrePage;
    private int currentPage;
    private int nexPage;
    private int perPage;
    private int totalCount;
    private BaseQuery query;
    private QueryResult<TEntity> result;

    public QueryResult<TEntity> getResult() {
        return result;
    }



    public PageBean(QueryResult<TEntity> result, BaseQuery query) {
        this(result.getList(),result.getCout(),query.getTake(),query.getSkip());
        this.query = query;
        this.result=result;

    }

    public BaseQuery getQuery() {
        return query;
    }




    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public boolean hasNexPage() {
        if (this.currentPage == totalPage) {
            return false;
        }
        return true;
    }

    public void setHasNexPage(boolean hasNexPage) {
        this.hasNexPage = hasNexPage;
    }

    public boolean hasPrePage() {
        return hasPrePage;
    }

    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNexPage() {
        return nexPage;
    }

    public void setNexPage(int nexPage) {
        this.nexPage = nexPage;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }



}
