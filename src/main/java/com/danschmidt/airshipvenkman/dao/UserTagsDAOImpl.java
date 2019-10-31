package com.danschmidt.airshipvenkman.dao;

import com.danschmidt.airshipvenkman.model.UserState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.servlet.ServletContext;

@Repository
public class UserTagsDAOImpl implements UserTagsDAO {
    @Autowired
    private ServletContext servletContext;

    @Override
    public UserState set(UserState user) {
        servletContext.setAttribute(user.getUser(), user);
        return this.get(user.getUser());
    }

    @Override
    public UserState get(String userName) {
        Object userObj = servletContext.getAttribute(userName);
        UserState userState = UserState.class.cast(userObj);
        return userState;
    }

    @Override
    public UserState create(String userName) {
        return new UserState(userName);
    }
}
