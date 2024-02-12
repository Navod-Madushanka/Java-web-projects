package com.navod.springboot.myfirstwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello!, What are you learning today?";
    }

    @RequestMapping("/say-hello-html")
    @ResponseBody
    public String sayHelloHtml(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<!DOCTYPE html>\n");
        stringBuffer.append("<html>\n");
        stringBuffer.append("    <head>\n");
        stringBuffer.append("        <title>SpringBoot</title>\n");
        stringBuffer.append("    </head>\n");
        stringBuffer.append("    <body>\n");
        stringBuffer.append("        <h1>My First Html Page With SpringBoot</h1>\n");
        stringBuffer.append("    </body>\n");
        stringBuffer.append("</html>");
        return stringBuffer.toString();
    }

    @RequestMapping("/say-hello-jsp")
    public String seyHelloJsp(){
        return "sayHello";
    }

}
