package com.navod.springboot.myfirstwebapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationLogin {
    Logger logger = LoggerFactory.getLogger(getClass());
    public boolean authenticate(String email, String password){
        boolean authentication = false;
        if(email.equals("navod@gmail.com") && password.equals("1234")){
            return authentication = true;
        }
        logger.debug("authentication = {}", authentication);
        return authentication;
    }
}
