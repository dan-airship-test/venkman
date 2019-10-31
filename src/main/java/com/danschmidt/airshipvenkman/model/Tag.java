package com.danschmidt.airshipvenkman.model;

import java.sql.Time;
import java.sql.Timestamp;

public class Tag {
    private String user;
    private Boolean isAdd;
    private Timestamp timeStamp;

    public Tag(String user, Boolean isAdd, Timestamp timestamp) {
        this.user = user;
        this.isAdd = isAdd;
        this.timeStamp = timestamp;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setIsAdd(Boolean isAdd) {
        this.isAdd = isAdd;
    }

    public Boolean getIsAdd() {
        return this.isAdd;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }
}