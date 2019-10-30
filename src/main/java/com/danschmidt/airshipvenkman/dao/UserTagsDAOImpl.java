package com.danschmidt.airshipvenkman.dao;

import com.danschmidt.airshipvenkman.domain.UserTags;
import com.danschmidt.airshipvenkman.domain.UserUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.servlet.ServletContext;

@Repository
public class UserTagsDAOImpl implements UserTagsDAO {
    @Autowired
    private ServletContext servletContext;

    @Override
    public UserTags updateUserTags(UserUpdate user) {
        UserTags existing = this.getUserTags(user.getUser());
        if (existing == null) {
            servletContext.setAttribute(user.getUser(), user);
        } else {

        }
        return getUserTags(user.getUser());
    }
    @Override
    public UserTags getUserTags(String userName) {
        Object userObj = servletContext.getAttribute(userName);
        UserTags userTags = UserTags.class.cast(userObj);
        return userTags;
    }
}
