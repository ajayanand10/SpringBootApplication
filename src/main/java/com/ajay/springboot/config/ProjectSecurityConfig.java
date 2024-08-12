package com.ajay.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class ProjectSecurityConfig {


//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//
//        //Permit all requests inside the application
//        http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
//        return http.build();
//    }


//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//
//        //Deny all requests inside the application
//        http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll());
//        return http.build();
//    }


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf((csrf)->csrf.disable())//csrf should be disabled for post and put http methods
                .authorizeHttpRequests((requests) ->
                        requests.requestMatchers("/hello/**").permitAll()
                                .requestMatchers("/users/**").hasAnyAuthority("ADMIN"))
                .httpBasic(Customizer.withDefaults());//added for enabling basic authentication
        return http.build();
    }

@Bean
public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
}

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withDefaultPasswordEncoder()//deprecated
                .username("user")
                .password("8976")
                .roles("USER")
                .build();
        UserDetails john = User.builder()
                .username("john")
                .password(passwordEncoder().encode("John123"))
                .roles("USER")
                .build();
        UserDetails ajay = User.withUsername("ajay")
                .password(passwordEncoder().encode("ajay123"))
                .roles("USER","ADMIN")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,john,ajay,admin);//stores the username and password in the memory of the application
    }
}
