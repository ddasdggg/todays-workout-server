package com.devchoi0926.todaysworkoutserver.controller;

import com.devchoi0926.todaysworkoutserver.dto.SignUpDto;
import com.devchoi0926.todaysworkoutserver.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    String nicknameCheck(String username, HttpServletRequest request, Model model) {
        System.out.println(username);
        boolean idCheck = registrationService.nicknameCheck(username);
        request.setAttribute("idCheck", idCheck);
        model.addAttribute("url", "/registrations/nickname-check-form");
        return "redirect";
    }

    @PostMapping
    String signUp(SignUpDto signUpDto, Model model) {
        registrationService.signUp(signUpDto);
        model.addAttribute("message", "회원가입되었습니다.");
        model.addAttribute("url", "/login");
        return "redirect";
    }
}
