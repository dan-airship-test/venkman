package com.danschmidt.airshipvenkman.dao;

import com.danschmidt.airshipvenkman.model.UserState;
import org.springframework.stereotype.Repository;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserStateDAOImpl implements UserStateDAO {
    ConcurrentHashMap<String, UserState> userState = new ConcurrentHashMap<String, UserState>(100, 0.75f, 100);

    @Override
    public UserState set(UserState user) {
        this.userState.put(user.getUser(), user);
        return this.get(user.getUser());
    }

    @Override
    public UserState get(String userName) {
        UserState userState = this.userState.get(userName);
        return userState;
    }

    @Override
    public UserState create(String userName) {
        return new UserState(userName);
    }
}
