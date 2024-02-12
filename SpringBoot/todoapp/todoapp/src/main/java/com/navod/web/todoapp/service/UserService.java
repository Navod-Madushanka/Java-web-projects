package com.navod.web.todoapp.service;

import com.navod.web.todoapp.entity.User;
import com.navod.web.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public boolean registerValidation(String username, String email, String password){
        boolean authorized = true;
        if(username.isBlank() || email.isBlank() || password.isBlank()){
            authorized = false;
        }
        return authorized;
    }
    public void saveUser(User user){
        userRepository.save(user);
    }
    public List<User> getUsers(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
