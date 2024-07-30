package com.security.ex.controller;

import com.security.ex.entity.User;
import com.security.ex.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaTray;
import java.util.Optional;

@Controller
@RequestMapping("/sc")
public class SecurityController {

    @Autowired
    private SecurityService service;
    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_XHTML_XML_VALUE)
    public String login() {
        return "Login";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET, produces = MediaType.APPLICATION_XHTML_XML_VALUE)
    public String dashboard() {
        return "Dashboard";
    }
    @PostMapping("/save")
    public User save(User user){
        User u = service.saveUser(user);
        return u;
    }

    @GetMapping("/user/get")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public User get(int id) {
        Optional<User> users = service.getUser(id);
        if(users.isPresent()){
            return users.get();
        }
        User user = new User();
        user.setUsername("User is not found");
        return user;
    }

    @DeleteMapping("/admin/delete")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String delete(int id){
        boolean isDeleted = service.deleteUser(id);
        return isDeleted ? "User delete successfully" : "Failed to delete user";
    }
}
