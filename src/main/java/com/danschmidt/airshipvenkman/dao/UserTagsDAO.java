package com.danschmidt.airshipvenkman.dao;

import com.danschmidt.airshipvenkman.domain.UserTags;
import com.danschmidt.airshipvenkman.domain.UserUpdate;

public interface UserTagsDAO {
    public UserTags updateUserTags(UserUpdate user);
    public UserTags getUserTags(String userName);
}
