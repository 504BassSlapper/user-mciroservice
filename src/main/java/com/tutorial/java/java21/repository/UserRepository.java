package com.tutorial.java.java21.repository;

import com.tutorial.java.java21.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository  extends JpaRepository<User, Long> {

    User findByName(String name);
}
