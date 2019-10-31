package com.danschmidt.airshipvenkman.model;

import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.Comparator;

public class UserState {
    private String user;
    private ArrayList<Tag> tagsReceived = new ArrayList<Tag>();
    private ArrayList<Tag> tagsCurrent = new ArrayList<Tag>();


    public UserState(String userName) {
        user = userName;
    }

    public void addTagReceived(Tag receivedTag) {
        this.tagsReceived.add(receivedTag);
    }

    public void addTagCurrent(Tag newTag) {
        // TODO: override equals method?
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
        this.tagsCurrent.remove(newTag);
    }

    public ArrayList<Tag> getTagsCurrent() {
        return this.tagsCurrent;
    }

    public String getUser() {
        return this.user;
    }

    public UserState updateState(UserUpdate userUpdate) {
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
