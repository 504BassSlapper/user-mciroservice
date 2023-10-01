package com.tutorial.java.java21.service;

import com.tutorial.java.java21.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitDataService {
    @Autowired
    private UserService userService;

    private static final Logger LOG = LoggerFactory.getLogger(InitDataService.class);

    public void loadData() {
        LOG.info("Set up initial context for dev profile");
        User user1 = User.builder().email("email@mail.com").name("stefen").build();
        userService.saveUser(user1);
        User user2 = User.builder().email("eddy@mail.com").name("Eddy").build();
        userService.saveUser(user2);
        LOG.info("the dev context have been set up");
    }
}
