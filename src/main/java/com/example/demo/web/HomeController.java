package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }


    @GetMapping("/users/login")
    public String login(){
        return "login";
    }

    @GetMapping("/users/register")
    public String register(){
        return "register";
    }

}
