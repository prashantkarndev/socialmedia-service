package com.rap.socialmedia.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentResponse {

    private long userId;
    private long postId;
    private String comment;
}
