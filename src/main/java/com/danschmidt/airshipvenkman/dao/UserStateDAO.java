package com.danschmidt.airshipvenkman.dao;

import com.danschmidt.airshipvenkman.model.UserState;

public interface UserStateDAO {
    public UserState set(UserState user);
    public UserState get(String userName);
    public UserState create(String userName);

}
