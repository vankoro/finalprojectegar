package com.example.SpringBootHR.config;

import com.example.SpringBootHR.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder getPasswordEncoder(){ return new BCryptPasswordEncoder();}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers(
                        "/employee", "/employee/search",
                        "/css/**",
                        "/static/**",
                        "/images/**",
                        "/webjars/**",
                        "/cdnjs/**"
                ).permitAll()
                .anyRequest().hasRole("ADMIN")
                .and()
                .formLogin().permitAll().defaultSuccessUrl("/employee")
                .and()
                .logout().permitAll().clearAuthentication(true).deleteCookies("JSESSIONID").logoutSuccessUrl("/employee");

        return http.build();
    }

}
