package com.devchoi0926.todaysworkoutserver.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

//TODO 대댓글
@Getter
@Table(name = "post_comment")
@Entity
public class PostComment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postCommentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    @OneToMany(mappedBy = "postComment", orphanRemoval = true)
    private Set<PostCommentLike> postCommentLikes;

    @OneToMany(mappedBy = "postComment", orphanRemoval = true)
    private Set<PostCommentReport> postCommentReports;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
