package com.rap.socialmedia.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class PostResponse {

    private long userId;
    private long postId;
    private String post;
}
