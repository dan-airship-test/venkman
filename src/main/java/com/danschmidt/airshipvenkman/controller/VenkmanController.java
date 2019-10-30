package com.danschmidt.airshipvenkman.controller;

import com.danschmidt.airshipvenkman.domain.UserTags;
import com.danschmidt.airshipvenkman.domain.UserUpdate;
import com.danschmidt.airshipvenkman.service.VenkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
public class VenkmanController {
    @Autowired
    private VenkmanService venkmanService;
    @ExceptionHandler({Exception.class})
    public void handleException(Exception e) {
        e.printStackTrace();
    }
    @PostMapping(path = "/api/tags", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserTags tagUser(@RequestBody UserUpdate incoming, HttpServletRequest request) throws Exception {
        UserTags updated = venkmanService.processTags(incoming);
        return updated;
    }
}