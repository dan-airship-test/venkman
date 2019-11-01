package com.danschmidt.airshipvenkman.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;

public class UserUpdate {
    @NotNull
    @NotBlank
    private String user;
    @NotNull
    private ArrayList<String> add;
    @NotNull
    private ArrayList<String> remove;
    @NotNull
    private Timestamp timestamp;
    UserUpdate(){}
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
    public void setTimestamp(Timestamp timestamp) {this.timestamp = timestamp;}
}
