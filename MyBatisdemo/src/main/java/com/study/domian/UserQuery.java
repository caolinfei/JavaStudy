package com.study.domian;

import java.io.Serializable;

public class UserQuery implements Serializable {
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;
}
