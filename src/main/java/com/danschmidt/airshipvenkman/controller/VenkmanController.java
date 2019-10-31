package com.danschmidt.airshipvenkman.controller;

import com.danschmidt.airshipvenkman.model.CurrentUserState;
import com.danschmidt.airshipvenkman.model.UserUpdate;
import com.danschmidt.airshipvenkman.service.VenkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class VenkmanController {
    @Autowired
    private VenkmanService venkmanService;
    @ExceptionHandler({Exception.class})
    public void handleException(Exception e) {
        e.printStackTrace();
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Error processing request."
        );
    }
    @PostMapping(path = "/api/tags", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CurrentUserState tagUser(@Valid @RequestBody UserUpdate incoming) throws Exception {
        // TODO: validate format
        CurrentUserState current = venkmanService.processTags(incoming);
        return current;
    }
}