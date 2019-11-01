package com.danschmidt.airshipvenkman.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class UserState {
    private String user;
    private ArrayList<Tag> tagsReceived = new ArrayList<Tag>();
    private ArrayList<Tag> tagsCurrent = new ArrayList<Tag>();


    public UserState(String userName) {
        user = userName;
    }

    public ArrayList<Tag> getTagsCurrent() {
        return tagsCurrent;
    }

    public void addTagCurrent(Tag newTag) {
        Boolean tagExists = false;
        for (Tag tag : this.tagsCurrent) {
            if (tag.getName().compareTo(newTag.getName()) == 0) {
                tagExists = true;
                break;
            }
        }
        if (!tagExists) {
            this.tagsCurrent.add(newTag);
        }
    }

    public void removeTagCurrent(Tag newTag) {
        Predicate<Tag> condition = tag -> tag.getName().equals(newTag.getName());
        this.tagsCurrent.removeIf(condition);
    }

    public String getUser() {
        return this.user;
    }

    public UserState updateState(UserUpdate userUpdate) throws JsonProcessingException {
        for (String add : userUpdate.getAdd()) {
            Tag newTag = new Tag(add,true, userUpdate.getTimestamp());
            this.tagsReceived.add(newTag);
        }
        for (String remove : userUpdate.getRemove()) {
            Tag newTag = new Tag(remove,false, userUpdate.getTimestamp());
            this.tagsReceived.add(newTag);
        }
        return this.generateCurrentState();
    }

    public UserState generateCurrentState() {
        // sort tags by timestamp and then add or remove tags
        this.tagsReceived.sort(Comparator.comparing(o -> o.getTimeStamp()));
        this.tagsCurrent.clear();
        for(Tag tag : this.tagsReceived) {
            if(tag.getIsAdd()) {
                this.addTagCurrent(tag);
            } else {
                this.removeTagCurrent(tag);
            }
        }
        return this;
    }
}
