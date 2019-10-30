package com.danschmidt.airshipvenkman.domain;

public class UserTags {
    private String user;
    private String[] tags;

    UserTags() {}

    public void setUserTags(String[] tags) {
        this.tags = tags;
    }

    public void setUser(String userName) {
        this.user = userName;
    }
}
