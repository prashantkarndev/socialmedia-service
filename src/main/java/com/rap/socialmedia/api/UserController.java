package com.rap.socialmedia.api;

import com.rap.socialmedia.dto.request.UserDto;
import com.rap.socialmedia.dto.response.UserResponse;
import com.rap.socialmedia.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {


  private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserDto user) {
        return new ResponseEntity<UserResponse>(userService.createUser(user), HttpStatus.CREATED);
    }
}
