package com.devchoi0926.todaysworkoutserver.service;

import com.devchoi0926.todaysworkoutserver.dto.SignUpDto;
import com.devchoi0926.todaysworkoutserver.model.User;
import com.devchoi0926.todaysworkoutserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    @PostConstruct
    void initUser() {
        SignUpDto signUpDto = new SignUpDto();
        signUpDto.setNickname("user");
        signUpDto.setPassword("1234");
        signUp(signUpDto);
    }

    public boolean signUp(SignUpDto signUpDto) {
        User user = User.builder()
                .nickname(signUpDto.getNickname())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .build();
        user = userRepository.save(user);

        return user != null;
    }

    public boolean nicknameCheck(String nickname) {
        return true;
    }
}
