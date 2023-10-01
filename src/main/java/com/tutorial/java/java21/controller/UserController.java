package com.tutorial.java.java21.controller;

import com.tutorial.java.java21.entity.User;
import com.tutorial.java.java21.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get")
public class UserController {
    public static final Logger LOG =  LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @GetMapping("/user/{name}")
    public ResponseEntity<User> getUser(@PathVariable String name) {
        User user = userService.findUserByName(name);
        if (user == null) {
            LOG.warn("The user {} is not found!", name);
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
        LOG.warn("The user {} is found!", name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
