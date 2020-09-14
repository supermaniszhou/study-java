package com.cheng.jwt.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String username;
    private String deptname;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", deptname='" + deptname + '\'' +
                '}';
    }
}
