package com.as.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http .csrf().disable() // Disable CSRF for simplicity (be cautious in
		 * production) .authorizeRequests() .anyRequest().authenticated() // Require
		 * authentication for any request .and() .formLogin() // Enable form-based login
		 * .loginProcessingUrl("/login") // URL to submit login data .permitAll();
		 */
    	
    	http
        .csrf().disable() 
        .authorizeRequests()
            .antMatchers("/", "/login", "/register","/save").permitAll()
            .anyRequest().authenticated()
        .and()
        .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/perform_login")
            .defaultSuccessUrl("/dashboard")
            .permitAll()
        .and()
        .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login")
            .permitAll();
    }
}
