package com.tutorial.java.java21;

import com.tutorial.java.java21.entity.User;
import com.tutorial.java.java21.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Scanner;

@SpringBootTest
class Java21ApplicationTests {
    @Autowired
    UserRepository userRepository;

    @Test
    public void givenValidInitData_whenCallingFindAll_thenReturnData() {
//        User user = User.builder().build();
//        user.setId(1);
//        user.setEmail("email");
//        user.setName("name1");
//        userRepository.save(user);
//        List<User> users = userRepository.findAll();

    }

    @Test
    void contextLoads() {
    }

}
