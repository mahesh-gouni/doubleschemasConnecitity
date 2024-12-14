package com.neoteric.doubleSchema.service;

import com.neoteric.doubleSchema.repo.user.UserRepository;
import com.neoteric.doubleSchema.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    // Change the method to return the saved user
    public User addinguser(User user) {
        // Save the user and return the saved entity
        return repository.save(user);
    }
}
