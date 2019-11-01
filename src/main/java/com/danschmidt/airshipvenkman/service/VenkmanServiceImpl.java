package com.danschmidt.airshipvenkman.service;

import com.danschmidt.airshipvenkman.dao.UserStateDAO;
import com.danschmidt.airshipvenkman.model.CurrentUserState;
import com.danschmidt.airshipvenkman.model.Tag;
import com.danschmidt.airshipvenkman.model.UserState;
import com.danschmidt.airshipvenkman.model.UserUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.LinkedHashSet;

@Service
public class VenkmanServiceImpl implements VenkmanService {
    @Autowired
    private UserStateDAO userStateDAO;
    @Override
    public synchronized CurrentUserState processTags(UserUpdate incoming) throws Exception {
        // remove dupes and remove add if a single add and remove for a tag.
        // if tag is included as both `remove` and `add`, remove add and treat as a single remove.
        UserUpdate cleaned = this.removeConflicts(this.removeDupes(incoming));
        // check if user exists yet, create if not.
        UserState existing = userStateDAO.get(incoming.getUser());
        if (existing == null) {
            existing = userStateDAO.create(incoming.getUser());
        }
        // add/remove tags to user state
        UserState updated = existing.updateState(cleaned);
        userStateDAO.set(updated);
        ArrayList<String> tags = new ArrayList<String>();
        for(Tag tag : updated.getTagsCurrent()) {
            tags.add(tag.getName());

        }
        CurrentUserState current = new CurrentUserState(updated.getUser(), tags);
        return current;
    }

    private UserUpdate removeDupes(UserUpdate incoming) {
        LinkedHashSet<String> addHashSet = new LinkedHashSet<String>(incoming.getAdd());
        incoming.setAdd(new ArrayList<String>(addHashSet));
        LinkedHashSet<String> removeHashSet = new LinkedHashSet<String>(incoming.getRemove());
        incoming.setRemove(new ArrayList<String>(removeHashSet));
        return incoming;
    }

    private UserUpdate removeConflicts(UserUpdate incoming) {
        for(String remove : incoming.getRemove()) {
            if (incoming.getAdd().contains(remove))  {
                incoming.getAdd().remove(remove);
            }
        }
        return incoming;
    }
}
