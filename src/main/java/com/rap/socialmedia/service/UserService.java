package com.rap.socialmedia.service;

import com.rap.socialmedia.dto.request.UserDto;
import com.rap.socialmedia.dto.response.UserResponse;
import com.rap.socialmedia.entity.User;
import com.rap.socialmedia.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserResponse createUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        User createdUser = userRepository.save(user);
        log.info("User created {}", createdUser.toString());
        return mapToResponse(createdUser);
    }

    private UserResponse mapToResponse(User createdUser) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(createdUser.getUserId());
        userResponse.setFirstName(createdUser.getFirstName());
        userResponse.setLastName(createdUser.getLastName());
        return  userResponse;
    }
}
