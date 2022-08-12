package com.devchoi0926.todaysworkoutserver.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeApiController {

    @GetMapping
    String home() {
        return "home";
    }
}
