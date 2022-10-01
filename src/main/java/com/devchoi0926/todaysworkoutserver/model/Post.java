package com.devchoi0926.todaysworkoutserver.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Table(name = "post")
@Entity
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String content;

    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private Set<PostComment> postComments;

    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private Set<PostLike> postLikes;

    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private Set<PostReport> postReports;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
