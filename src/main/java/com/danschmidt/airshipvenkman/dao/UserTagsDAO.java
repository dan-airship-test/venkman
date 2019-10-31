package com.danschmidt.airshipvenkman.dao;

import com.danschmidt.airshipvenkman.model.UserState;
import com.danschmidt.airshipvenkman.model.UserUpdate;

public interface UserTagsDAO {
    public UserState set(UserState user);
    public UserState get(String userName);
}
