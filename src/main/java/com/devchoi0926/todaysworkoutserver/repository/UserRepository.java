package com.devchoi0926.todaysworkoutserver.repository;

import com.devchoi0926.todaysworkoutserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByNickname(String nickname);
}
