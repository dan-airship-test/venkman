package com.danschmidt.airshipvenkman.service;

import com.danschmidt.airshipvenkman.model.CurrentUserState;
import com.danschmidt.airshipvenkman.model.UserUpdate;

public interface VenkmanService {
     CurrentUserState processTags(UserUpdate incoming) throws Exception;
}
