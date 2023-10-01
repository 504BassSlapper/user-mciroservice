package com.tutorial.java.java21.service;

import com.tutorial.java.java21.entity.User;
import com.tutorial.java.java21.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepository userRepository;

    public User findUserByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
