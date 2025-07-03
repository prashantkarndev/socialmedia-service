package com.rap.socialmedia.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PostDto {

    @NotEmpty(message = "Please enter the post. Can't be empty")
    private String post;
}
