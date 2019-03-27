package com.crud.domian;

import java.util.ArrayList;

public class PageBean<TEntiry extends ArrayList<BaseEntity>,TQuery extends  BaseQuery> {
    private int totalPage;
    private boolean hasNexPage;
    private  boolean hasPrePage;
    private int curruentPage;
    private int nexPage;
    private int perPage;

    public BaseQuery getQuery() {
        return query;
    }

    public void setQuery(BaseQuery query) {
        this.query = query;
    }

    private BaseQuery query;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public boolean hasNexPage() {
        if(this.curruentPage==totalPage)
        {
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

    public int getCurruentPage() {
        return curruentPage;
    }

    public void setCurruentPage(int curruentPage) {
        this.curruentPage = curruentPage;
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

    private  int totalCount;

}
