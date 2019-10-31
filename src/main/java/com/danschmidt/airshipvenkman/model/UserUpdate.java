package com.danschmidt.airshipvenkman.model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class UserUpdate {
    private String user;
    private ArrayList<String> add;
    private ArrayList<String> remove;
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
    public ArrayList<String> getAdd() { return this.add; }
    public void setAdd(ArrayList<String> add) { this.add = add; }
    public ArrayList<String> getRemove() { return this.remove; }
    public void setRemove(ArrayList<String> remove) { this.remove = remove; }
    public Timestamp getTimestamp() { return this.timestamp;}
}
