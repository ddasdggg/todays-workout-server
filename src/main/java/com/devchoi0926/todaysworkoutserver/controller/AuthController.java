package com.devchoi0926.todaysworkoutserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    String login() {
        return "login";
    }
}
