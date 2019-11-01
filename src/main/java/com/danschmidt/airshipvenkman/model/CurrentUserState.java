package com.danschmidt.airshipvenkman.model;

import java.util.ArrayList;

public class CurrentUserState {
    private String user;
    private ArrayList<String> tags;

    public CurrentUserState(String user, ArrayList<String> tags) {
        this.user = user;
        this.tags = tags;
    }
    public ArrayList<String> getTags() {
        return tags;
    }
    public String getUser() {
        return user;
    }

}
