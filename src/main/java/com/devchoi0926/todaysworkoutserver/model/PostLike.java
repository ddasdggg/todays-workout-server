package com.devchoi0926.todaysworkoutserver.model;


import com.devchoi0926.todaysworkoutserver.model.Id.UserPostId;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Table(name = "post_like")
@Entity
public class PostLike {

    @EmbeddedId
    private UserPostId userPostId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("postId")
    @JoinColumn(name = "post")
    private Post post;

    @CreatedDate
    private LocalDateTime cratedDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
