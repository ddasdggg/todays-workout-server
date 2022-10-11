package com.devchoi0926.todaysworkoutserver.service;

import com.devchoi0926.todaysworkoutserver.dto.SignUpDto;
import com.devchoi0926.todaysworkoutserver.model.User;
import com.devchoi0926.todaysworkoutserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    @PostConstruct
    void initUser() {
        SignUpDto signUpDto = new SignUpDto();
        signUpDto.setUsername("user");
        signUpDto.setPassword("1234");
        signUp(signUpDto);
    }

    public boolean signUp(SignUpDto signUpDto) {
        User user = User.builder()
                .nickname(signUpDto.getUsername())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .build();
        user = userRepository.save(user);

        return user != null;
    }

    public boolean nicknameCheck(String nickname) {
        Optional<User> optUser = userRepository.findByNickname(nickname);
        return optUser.isEmpty();
    }
}
