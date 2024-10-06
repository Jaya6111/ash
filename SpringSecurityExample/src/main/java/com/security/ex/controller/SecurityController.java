package com.security.ex.controller;

import com.security.ex.config.MyUserDetailsService;
import com.security.ex.entity.LoginForm;
import com.security.ex.entity.User;
import com.security.ex.jwt.JwtService;
import com.security.ex.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SecurityController {

    @Autowired
    private SecurityService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/home")
    public String home() {
        return "Login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Dashboard";
    }

    @PostMapping("/register/save")
    public User save(@RequestBody User user){
        return service.saveUser(user);
    }

    @GetMapping("/admin/getUsers")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/user/get/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public User get(@PathVariable int id) throws UsernameNotFoundException{
        Optional<User> users = service.getUser(id);
        if(users.isPresent()){
            return users.get();
        }
        throw new UsernameNotFoundException("User not found with id:" + id);
    }

    @DeleteMapping("/admin/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(int id){
        boolean isDeleted = service.deleteUser(id);
        return isDeleted ? "User delete successfully" : "Failed to delete user";
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody LoginForm loginForm) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginForm.getUsername(), loginForm.getPassword()
        ));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(myUserDetailsService.loadUserByUsername(loginForm.getUsername()));
        } else {
            throw new UsernameNotFoundException("Invalid credentials");
        }
    }
}
