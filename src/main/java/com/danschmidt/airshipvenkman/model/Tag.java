package com.danschmidt.airshipvenkman.model;

import java.sql.Timestamp;

public class Tag {
    private String name;
    private Boolean isAdd;
    private Timestamp timeStamp;

    public Tag(String name, Boolean isAdd, Timestamp timestamp) {
        this.name = name;
        this.isAdd = isAdd;
        this.timeStamp = timestamp;
    }

    public Boolean getIsAdd() {
        return this.isAdd;
    }

    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public String getName() {
        return this.name;
    }
}