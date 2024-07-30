package com.as.java17.service;

import com.as.java17.been.User;
import com.as.java17.repository.UserRepository;
import com.as.java17.request.GetUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl {
    @Autowired
    private UserRepository userRepository;

    public User get(String email) {

        try {
            return userRepository.findByEmail(email).get();
        } catch (Exception e) {
            return null;
        }
    }

    public String post(User user) {
        try {
            User savedUser = userRepository.save(user);
            return "User saved Successfully";
        } catch (Exception e) {
            return "Failed to save the user";
        }
    }

    public User getuser(String id) {
        return userRepository.findById(id).get();
    }

    public User getuser(GetUserRequest request) {
        Optional<User> users = userRepository.findByEmail(request.getEmail());
        return users.orElse(null);
    }

    public User getByName(String name) {
        return userRepository.findByName(name).get(0);
    }
}
