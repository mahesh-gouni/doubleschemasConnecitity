package com.neoteric.doubleSchema.controller;

import com.neoteric.doubleSchema.service.UserService;
import com.neoteric.doubleSchema.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        // Call service method to save the user
        User savedUser = userService.addinguser(user);

        // Return the saved user with HTTP status CREATED
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
