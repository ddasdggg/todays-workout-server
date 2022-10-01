package com.devchoi0926.todaysworkoutserver.model;

import com.devchoi0926.todaysworkoutserver.model.Id.UserPostId;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Table(name = "post_report")
@Entity
public class PostReport {

    @EmbeddedId
    private UserPostId userPostId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("postId")
    @JoinColumn(name = "post_id")
    private Post post;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
