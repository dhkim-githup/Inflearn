package com.example.security.repository;

import com.example.security.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    //@EntityGraph(attributePaths = {"boards"})
    //List<User> findAll();

    User findByUsername(String username);
}
