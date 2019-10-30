package com.danschmidt.airshipvenkman.service;

import com.danschmidt.airshipvenkman.domain.UserTags;
import com.danschmidt.airshipvenkman.domain.UserUpdate;

public interface VenkmanService {
    public UserTags processTags(UserUpdate incoming) throws Exception;
}
