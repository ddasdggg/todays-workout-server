package com.devchoi0926.todaysworkoutserver.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Table(name = "user")
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Post> posts;

    private String nickname;

    private String password;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
