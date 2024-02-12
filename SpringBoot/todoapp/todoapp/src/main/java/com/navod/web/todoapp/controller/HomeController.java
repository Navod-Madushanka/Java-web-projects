package com.navod.web.todoapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class HomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        return "home";
    }
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public ResponseEntity<String> addTodo(@RequestBody Map<String, String> todoMap){
        String title = todoMap.get("title");
        String todo = todoMap.get("todo");
        boolean status = false;

    }
}
