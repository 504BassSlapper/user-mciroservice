package com.tutorial.java.java21.controller;

import com.tutorial.java.java21.dto.UserRequestDto;
import com.tutorial.java.java21.entity.User;
import com.tutorial.java.java21.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    public static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    /**
     * get User using path in url
     *
     * @param name user's name
     * @return ResponseEntity
     */
    @GetMapping("/person/{name}")
    public ResponseEntity<User> getUser(@PathVariable String name) {
        User user = userService.findUserByName(name);
        if (user == null) {
            LOG.warn("The user {} is not found!", name);
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
        LOG.info("The user {} is found!", name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/person")
    public ResponseEntity<User> getUserByName(@RequestBody UserRequestDto userRequestDto) {
        User user = userService.findUserByName(userRequestDto.getName());
        if (user == null) {
            LOG.warn("The user {} is not found!", userRequestDto.getName());
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        }
        LOG.info("The user {} is found!", userRequestDto.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/persons")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users == null || users.isEmpty()) {
            LOG.warn("No user found!");
            return new ResponseEntity<>(users, HttpStatus.NOT_FOUND);
        }
        LOG.info("Users found: {}", users.size());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
