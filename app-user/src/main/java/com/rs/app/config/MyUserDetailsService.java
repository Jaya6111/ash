/*
 * package com.rs.app.config;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Component;
 * 
 * import com.rs.app.bean.User; import com.rs.app.repositories.UserRepository;
 * 
 * @Component public class MyUserDetailsService implements UserDetailsService {
 * 
 * @Autowired private UserRepository repo;
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException {
 * 
 * User user = repo.findByUsername(username); if (user == null) { throw new
 * UsernameNotFoundException("User Not Found"); }
 * 
 * return new UserPrincipal(user); }
 * 
 * }
 */