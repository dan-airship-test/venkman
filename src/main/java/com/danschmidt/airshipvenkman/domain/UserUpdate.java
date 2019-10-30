package com.danschmidt.airshipvenkman.domain;

import java.sql.Timestamp;

public class UserUpdate {
    private String user;
    private String[] add;
    private String[] remove;
    private Timestamp timestamp;

    UserUpdate() {}
    public UserUpdate(String user) {
        this.user = user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getUser() {
        return this.user;
    }
}
