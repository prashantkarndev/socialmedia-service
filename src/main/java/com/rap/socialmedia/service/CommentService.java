package com.rap.socialmedia.service;

import com.rap.socialmedia.dto.request.CommentDto;
import com.rap.socialmedia.dto.response.CommentResponse;
import com.rap.socialmedia.entity.Comment;
import com.rap.socialmedia.entity.Post;
import com.rap.socialmedia.entity.User;
import com.rap.socialmedia.exception.PostNotFoundException;
import com.rap.socialmedia.exception.UserNotFoundException;
import com.rap.socialmedia.repo.CommentRepository;
import com.rap.socialmedia.repo.PostRepository;
import com.rap.socialmedia.repo.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommentService {

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    private final CommentRepository commentRepository;

    public CommentService(UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }


    @Transactional
    public CommentResponse createComment(long userId, long postId, CommentDto commentDto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User doesn't exist with id:" + userId));
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException("Post doesn't exist with id:" + postId));

        Comment comment = new Comment();
        comment.setComment(commentDto.getComment());
        comment.setPost(post);
        comment.setUser(user);

        Comment createdComment = commentRepository.save(comment);
        log.info("Comment created {}", createdComment);
        return mapToResponse(createdComment);
    }

    private CommentResponse mapToResponse(Comment createdComment) {
        return CommentResponse.builder()
                .comment(createdComment.getComment())
                .postId(createdComment.getPost().getPostId())
                .userId(createdComment.getUser().getUserId())
                .build();
    }
}
