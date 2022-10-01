package com.devchoi0926.todaysworkoutserver.model.Id;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserPostCommentId implements Serializable {

    private int userId;

    private int postCommentId;
}
