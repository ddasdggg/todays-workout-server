package com.devchoi0926.todaysworkoutserver.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Post> posts;

    private String nickname;

    private String password;

    private String role;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    @Builder
    public User(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
        this.role = "user";
    }
}
