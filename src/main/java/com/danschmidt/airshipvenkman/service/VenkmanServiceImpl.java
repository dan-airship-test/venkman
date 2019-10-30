package com.danschmidt.airshipvenkman.service;

import com.danschmidt.airshipvenkman.dao.UserTagsDAO;
import com.danschmidt.airshipvenkman.domain.UserTags;
import com.danschmidt.airshipvenkman.domain.UserUpdate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenkmanServiceImpl implements VenkmanService{
    @Autowired
    private UserTagsDAO userTagsDAO;
    @Override
    public UserTags processTags(UserUpdate incoming) throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        UserTags existing = userTagsDAO.getUserTags(incoming.getUser());
        UserTags updated = userTagsDAO.updateUserTags(incoming);
        System.out.println(ow.writeValueAsString(updated));
        return updated;
    }

}
