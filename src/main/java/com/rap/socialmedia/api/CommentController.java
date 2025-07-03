package com.rap.socialmedia.api;

import com.rap.socialmedia.dto.request.CommentDto;
import com.rap.socialmedia.dto.response.CommentResponse;
import com.rap.socialmedia.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

   private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/user/{userId}/post/{postId}")
    ResponseEntity<CommentResponse> createComment(@PathVariable long userId, @PathVariable long postId, @Valid @RequestBody CommentDto commentDto) {
        return new ResponseEntity<CommentResponse>(commentService.createComment(userId, postId, commentDto), HttpStatus.CREATED);
    }
}
