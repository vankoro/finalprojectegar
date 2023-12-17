package com.example.SpringBootHR.service;

import com.example.SpringBootHR.model.UserRepo;
import com.example.SpringBootHR.model.entity.User;
import com.example.SpringBootHR.security.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByLogin(username);

        if (user == null){
            throw new UsernameNotFoundException("Пользователь не найден");
        }

        return new UserDetail(user);
    }
}
