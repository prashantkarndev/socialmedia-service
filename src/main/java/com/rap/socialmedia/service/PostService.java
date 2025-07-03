package com.rap.socialmedia.service;

import com.rap.socialmedia.dto.request.PostDto;
import com.rap.socialmedia.dto.response.PostResponse;
import com.rap.socialmedia.entity.Post;
import com.rap.socialmedia.entity.User;
import com.rap.socialmedia.exception.UserNotFoundException;
import com.rap.socialmedia.repo.PostRepository;
import com.rap.socialmedia.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public PostResponse createPostByUser(long userId, PostDto postDto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User doesn't exist with id:" + userId));
        Post post = new Post();
        post.setUser(user);
        post.setPost(postDto.getPost());

        Post createdPost = postRepository.save(post);
        log.info("Post is created : {}", createdPost);
        return mapToPostResponse(createdPost);
    }

    private PostResponse mapToPostResponse(Post createdPost) {
        return PostResponse.builder()
                .postId(createdPost.getPostId())
                .userId(createdPost.getUser().getUserId())
                .post(createdPost.getPost())
                .build();
    }
}
