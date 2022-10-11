package com.devchoi0926.todaysworkoutserver.controller;

import com.devchoi0926.todaysworkoutserver.dto.SignUpDto;
import com.devchoi0926.todaysworkoutserver.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/registrations")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping
    String signUpFrom() {
        return "signUp";
    }

    @GetMapping("/nickname-check-form")
    String nicknameCheckForm() {
        return "nicknameCheck";
    }

    @PostMapping("/nickname-check")
    String nicknameCheck(String username, Model model) {
        boolean idCheck = registrationService.nicknameCheck(username);
        model.addAttribute("idCheck", idCheck);
        if (idCheck) {
            model.addAttribute("username", username);
        }
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
