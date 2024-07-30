package com.as.java17.controller;

import com.as.java17.been.User;
import com.as.java17.request.GetUserRequest;
import com.as.java17.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private ServiceImpl service;

    @GetMapping("/getUser/{email}")
    public User get(@PathVariable("email") String email) {
        return service.get(email);
    }

    @PostMapping("/post")
    public String post(@RequestBody User user) {
        return service.post(user);
    }

    @GetMapping("/id/{id}")
    public User getuser(@PathVariable String id) {
        return service.getuser(id);
    }

    @GetMapping("/view")
    public String view() {
        return "Hello.html";
    }

    @GetMapping("/user")
    public User getUser(@RequestBody GetUserRequest request) {
        return service.getuser(request);
    }

    @GetMapping("/name/{name}")
    public User getByName(@PathVariable String name) {
        return service.getByName(name);
    }
}
