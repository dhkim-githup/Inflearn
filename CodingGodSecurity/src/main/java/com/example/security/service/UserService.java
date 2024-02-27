package com.example.security.service;

import com.example.security.model.Role;
import com.example.security.model.User;
import com.example.security.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User save(User user) {
        String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        user.setEnabled(true);
        Role role  = new Role();
        role.setId(1l);
        user.getRoles().add(role);
        return userRepository.save(user);
    }
}
