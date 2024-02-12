package com.navod.springboot.myfirstwebapp.controller;

import com.navod.springboot.myfirstwebapp.service.AuthenticationLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private AuthenticationLogin authenticationLogin;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public LoginController(AuthenticationLogin authenticationLogin) {
        this.authenticationLogin = authenticationLogin;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private String index(@RequestParam String email, @RequestParam String password, ModelMap model){
        boolean authenticate = authenticationLogin.authenticate(email, password);
        if(authenticate){
            model.put("email", email);
            model.put("password", password);
            return "welcome";
        }
        model.put("error", "Invalid username or password");
        return "login";
    }
}
