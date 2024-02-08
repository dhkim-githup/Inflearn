package com.example.security.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true) // username 중복방지
    private String username;

    private String password;
    private String role;
}
