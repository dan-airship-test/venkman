package com.danschmidt.airshipvenkman.service;

import com.danschmidt.airshipvenkman.dao.UserTagsDAO;
import com.danschmidt.airshipvenkman.model.UserState;
import com.danschmidt.airshipvenkman.model.UserUpdate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.LinkedHashSet;

@Service
public class VenkmanServiceImpl implements VenkmanService {
    @Autowired
    private UserTagsDAO userTagsDAO;
    @Override
    public synchronized UserState processTags(UserUpdate incoming) throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        // remove dupes and remove add if a single add and remove for a tag.
        // if tag is included as both `remove` and `add`, remove add and treat as a single remove.
        UserUpdate cleaned = this.removeConflicts(this.removeDupes(incoming));

        // lock on username
        synchronized(incoming.getUser().intern()) {
            // check if user exists yet, create if not.
            UserState existing = userTagsDAO.get(incoming.getUser());
            if (existing == null) {
                existing = userTagsDAO.create(incoming.getUser());
            }
            // add/remove tags to user state
            UserState updated = existing.updateState(cleaned);
            userTagsDAO.set(updated);
            System.out.println(ow.writeValueAsString(updated));
            return updated;

        }
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
