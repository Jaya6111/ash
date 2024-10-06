package com.security.ex.config;

import com.security.ex.entity.User;
import com.security.ex.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private SecurityRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<User> users = repository.findByUsername(username);
        if(!users.isEmpty()) {
            var userObj = users.get(0);
            return org.springframework.security.core.userdetails.User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(getRoles(userObj))
                    .build();
        }else
            throw new UsernameNotFoundException("User Not Found");
    }

    private String[] getRoles(User userObj){
        if(userObj.getRole() == null){
            return new String[] {"USER"};
        }
        return userObj.getRole().split(",");
    }
}
