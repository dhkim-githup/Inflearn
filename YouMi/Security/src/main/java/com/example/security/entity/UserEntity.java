package com.example.security.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true) // username 중복방지
    private String username;

    private String password;
    private String role;

    /*
    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
    */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity entity)) return false;
        return id == entity.id && Objects.equals(username, entity.username) && Objects.equals(password, entity.password) && Objects.equals(role, entity.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role);
    }


}
