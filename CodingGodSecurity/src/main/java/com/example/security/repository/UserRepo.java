package com.example.security.repository;

import com.example.security.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {

    //@EntityGraph(attributePaths = {"boards"})
    //List<User> findAll();

    User findByUsername(String username);

    // JPQL
    @Query("select u from User u where u.username like %?1%")
    List<User> findByUsernameQuery(String username);

    @Query(value = "select * from User u where u.username like %?1%", nativeQuery = true)
    List<User> findByUsernameNativeQuery(String username);
}
