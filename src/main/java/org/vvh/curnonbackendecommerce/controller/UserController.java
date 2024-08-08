package org.vvh.curnonbackendecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.vvh.curnonbackendecommerce.dto.user.RegisterUserRequest;
import org.vvh.curnonbackendecommerce.entity.User;
import org.vvh.curnonbackendecommerce.service.UserService;

@RestController
@RequestMapping(path = "api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @GetMapping("")
    public User getUser() {
        try {
            return userService.getUserByUsername("hoang");
        } catch (Exception e) {
            log.error(e.getMessage());
            return new User();
        }
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody RegisterUserRequest request) {
    }
}
