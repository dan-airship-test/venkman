package com.danschmidt.airshipvenkman.dao;

import com.danschmidt.airshipvenkman.model.UserState;

public interface UserTagsDAO {
    public UserState set(UserState user);
    public UserState get(String userName);
    public UserState create(String userName);

}
