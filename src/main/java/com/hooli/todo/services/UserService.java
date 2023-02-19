package com.hooli.todo.services;

import com.hooli.todo.exceptions.ResourceNotFoundException;
import com.hooli.todo.models.User;
import com.hooli.todo.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(@PathVariable Long userId, User userRequest) {
        var user = userRepository.findById(userId).orElseThrow
                (() -> new ResourceNotFoundException("The user with the ID of " + userId + " was not found."));
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmailAddress(userRequest.getEmailAddress());
        user.setPassword(userRequest.getPassword());
        return userRepository.save(user);
    }

    public User deleteUser(@PathVariable Long userId) {
        var user = userRepository.findById(userId).orElseThrow
                (() -> new ResourceNotFoundException("The user with the ID of " + userId + " was not found."));
        userRepository.deleteById(userId);
        return user;
    }

    public User getUser(@PathVariable Long userId) {
        return userRepository.findById(userId).orElseThrow
                (() -> new ResourceNotFoundException("The user with the ID of " + userId + " was not found."));
    }
}