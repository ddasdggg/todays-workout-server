package com.devchoi0926.todaysworkoutserver.model;

import com.devchoi0926.todaysworkoutserver.model.Id.UserPostCommentId;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Table(name = "post_comment_like")
@Entity
public class PostCommentLike {

    @EmbeddedId
    private UserPostCommentId userPostCommentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("postCommentId")
    @JoinColumn(name = "post_comment_id")
    private PostComment postComment;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
