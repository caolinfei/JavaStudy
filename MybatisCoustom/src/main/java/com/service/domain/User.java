package com.service.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {


    @Override
    public String toString() {
        return "User{" +

                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", brithDate=" + brithDate +
                '}';
    }

    //public Integer getId() {
       // return id;
    //}

    //public void setId(Integer id) {
        //this.id = id;
   // }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    //private Integer id;
    private String username;
    private String password;

    public Date getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(Date brithDate) {
        this.brithDate = brithDate;
    }

    private Date brithDate;


}
