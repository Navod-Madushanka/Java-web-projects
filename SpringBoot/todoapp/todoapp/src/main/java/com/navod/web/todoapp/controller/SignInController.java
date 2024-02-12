package com.navod.web.todoapp.controller;

import com.navod.web.todoapp.entity.User;
import com.navod.web.todoapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class SignInController {
    private UserService userService;

    public SignInController(UserService userService) {
        this.userService = userService;
    }

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String index(){
        logger.debug("It is Working");
        return "signin";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> registerUser(@RequestBody Map<String, String> userMap) {
        String username = userMap.get("username");
        String email = userMap.get("email");
        String password = userMap.get("password");

        if (userService.registerValidation(username, email, password)) {
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);

            userService.saveUser(user);

            return ResponseEntity.ok("Super"); // Send a 200 OK response with a body
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Good"); // Send a 400 Bad Request response with a body
    }

}
