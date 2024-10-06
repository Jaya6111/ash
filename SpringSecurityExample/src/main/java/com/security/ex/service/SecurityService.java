package com.security.ex.service;

import com.security.ex.entity.User;
import com.security.ex.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecurityService {

    @Autowired
    private SecurityRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole(user.getRole().toUpperCase());
        return repository.save(user);
    }
    public Optional<User> getUser(int id) {
        return repository.findById(id);

    }

    public boolean deleteUser(int id) {

       try{
           repository.deleteById(id);
           return true;
       }catch (Exception e){
           return false;
       }
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
