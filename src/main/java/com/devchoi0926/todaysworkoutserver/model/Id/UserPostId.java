package com.devchoi0926.todaysworkoutserver.model.Id;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserPostId implements Serializable {

    private int userId;

    private int postId;
}
