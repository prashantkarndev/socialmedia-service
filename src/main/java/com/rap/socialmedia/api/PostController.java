package com.rap.socialmedia.api;

import com.rap.socialmedia.dto.request.PostDto;
import com.rap.socialmedia.dto.response.PostResponse;
import com.rap.socialmedia.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {


    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value = "/user/{userId}")
    public ResponseEntity<PostResponse> createPostByUser(@PathVariable long userId, @Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<PostResponse>(postService.createPostByUser(userId, postDto), HttpStatus.CREATED);
    }
}
