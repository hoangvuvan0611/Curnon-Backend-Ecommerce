package org.vvh.curnonbackendecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.vvh.curnonbackendecommerce.dto.request.RegisterUserRequest;
import org.vvh.curnonbackendecommerce.dto.response.ResponseData;
import org.vvh.curnonbackendecommerce.dto.response.ResponseError;
import org.vvh.curnonbackendecommerce.entity.User;
import org.vvh.curnonbackendecommerce.service.UserService;

@RestController
@RequestMapping(path = "api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @GetMapping("/{username}")
    public ResponseData<?> getUserByUsername(@PathVariable String username) {
        try {
            User user = userService.getUserByUsername(username);
            return new ResponseData<>(HttpStatus.OK.value(), "Getting user successfully.", user);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Error while getting user: " + e.getMessage());
        }
    }

    @GetMapping("/{email}")
    public ResponseData<?> getUserByEmail(@PathVariable String email) {
        try {
            User user = userService.getUserByUsername(email);
            return new ResponseData<>(HttpStatus.OK.value(), "Getting user successfully.", user);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Error while getting user: " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseData<?> registerUser(@RequestBody RegisterUserRequest request) {
        try {
            userService.createUser(request);
            return new ResponseData<>(HttpStatus.CREATED.value(), "User registered successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error while creating user", e);
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Error while create user: " + e.getMessage());
        }
    }
}
