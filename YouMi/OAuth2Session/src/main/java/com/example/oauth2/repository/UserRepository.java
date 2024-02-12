package com.example.oauth2.repository;

import com.example.oauth2.dto.UserEntityOauth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntityOauth, Long> {

    UserEntityOauth findByUsername(String username);

}
