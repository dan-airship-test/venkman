package com.danschmidt.airshipvenkman.controller;

import com.danschmidt.airshipvenkman.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.danschmidt.airshipvenkman.service.VenkmanService;

import java.util.concurrent.CompletableFuture;

@RestController
public class VenkmanController {
    @ExceptionHandler
    public void handleException() {
        //
    }
    @PostMapping(path = "/api/tags", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User tag(@RequestBody User user) throws Exception {
        VenkmanService service = new VenkmanService();

            // use completableFuture because real data access would be async
            CompletableFuture<User> future = service.processTags();
            User result =  future.get();
            return result;
    }
}