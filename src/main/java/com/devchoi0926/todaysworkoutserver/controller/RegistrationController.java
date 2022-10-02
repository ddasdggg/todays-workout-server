package com.devchoi0926.todaysworkoutserver.controller;

import com.devchoi0926.todaysworkoutserver.dto.SignUpDto;
import com.devchoi0926.todaysworkoutserver.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registrations")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping
    String signUpFrom() {
        return "signUp";
    }

    @PostMapping
    String signUp(SignUpDto signUpDto, Model model) {
        registrationService.signUp(signUpDto);
        return "redirect:/login";
    }
}
