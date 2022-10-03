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

    @GetMapping("/nickname-check")
    String nicknameCheckForm(String nickname) {
        registrationService.nicknameCheck(nickname);
        return "nicknameCheck";
    }

    @PostMapping
    String signUp(SignUpDto signUpDto, Model model) {
        registrationService.signUp(signUpDto);
        model.addAttribute("message", "회원가입되었습니다.");
        model.addAttribute("url", "/login");
        return "redirect";
    }
}
