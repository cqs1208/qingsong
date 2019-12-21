package com.qingsong.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author : chenqingsong
 * @date : 2019-09-19 17:00
 */
@Data
public class User {

    private String username;

    private String password;

    private Date lastLoginTime;

    private String token;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
