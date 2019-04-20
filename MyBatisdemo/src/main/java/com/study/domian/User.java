package com.study.domian;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    @Override
    public String toString() {
        return "User{" +
                "UserName='" + UserName + '\'' +
                ", password='" + password + '\'' +
                ", brithDate=" + brithDate +
                ", uid=" + uid +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(Date brithDate) {
        this.brithDate = brithDate;
    }

    private String UserName;
    private String password;
    private Date brithDate;

    //private Integer id;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    private Integer uid;
   /* public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/
}

