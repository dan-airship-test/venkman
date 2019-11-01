package com.danschmidt.airshipvenkman;

import com.danschmidt.airshipvenkman.model.CurrentUserState;
import com.danschmidt.airshipvenkman.model.UserUpdate;
import com.danschmidt.airshipvenkman.service.VenkmanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.ArrayList;

@SpringBootTest
class AirshipVenkmanApplicationTests {
    @Autowired
    VenkmanService venkmanService;

    @Test
    void minimum() {
        // single tag add for new user
        UserUpdate user  = new UserUpdate("my_user");
        ArrayList<String> add = new ArrayList<>();
        add.add("beyhive_member");
        user.setAdd(add);
        ArrayList<String> remove = new ArrayList<>();
        user.setRemove(remove);
        user.setTimestamp(new Timestamp(System.currentTimeMillis()));
        try {
            CurrentUserState currentUserState = venkmanService.processTags(user);
            assert(currentUserState.getUser().compareTo(user.getUser()) == 0);
            assert(currentUserState.getTags().contains("beyhive_member"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void addRemoveTags() {
        UserUpdate user  = new UserUpdate("my_user");
        ArrayList<String> add = new ArrayList<>();
        add.add("pdx_travel");
        add.add("blazers_fan");
        user.setAdd(add);
        ArrayList<String> remove = new ArrayList<>();
        remove.add("pdx_travel");
        user.setRemove(remove);
        user.setTimestamp(new Timestamp(System.currentTimeMillis()));
        try {
            CurrentUserState currentUserState = venkmanService.processTags(user);
            assert(currentUserState.getUser().compareTo(user.getUser()) == 0);
            assert(currentUserState.getTags().contains("beyhive_member"));
            assert(currentUserState.getTags().contains("blazers_fan"));
            assert(!currentUserState.getTags().contains("pdx_travel"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
