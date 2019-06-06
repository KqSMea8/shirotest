package com.shiro.shiro_00.entity;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -6667316139673575453L;
    private String name;
    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
