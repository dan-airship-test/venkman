package com.danschmidt.airshipvenkman.service;

import com.danschmidt.airshipvenkman.model.UserState;
import com.danschmidt.airshipvenkman.model.UserUpdate;

public interface VenkmanService {
    public UserState processTags(UserUpdate incoming) throws Exception;
}
