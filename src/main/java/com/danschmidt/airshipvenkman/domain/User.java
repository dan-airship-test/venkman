package com.danschmidt.airshipvenkman.domain;

import java.sql.Timestamp;

public class User {
    private String userId;
    private String[] add;
    private String[] remove;
    private Timestamp timestamp;

    User() {}
    public User(String userId) {
        this.userId = userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserId() {
        return this.userId;
    }
}
