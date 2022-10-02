package com.devchoi0926.todaysworkoutserver.config.security;

import com.devchoi0926.todaysworkoutserver.model.User;
import com.devchoi0926.todaysworkoutserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByNickname(username).orElseThrow(() -> new UsernameNotFoundException("존재하지않는 아이디입니다."));
        return new org.springframework.security.core.userdetails.User(user.getNickname(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("user")));
    }
}
