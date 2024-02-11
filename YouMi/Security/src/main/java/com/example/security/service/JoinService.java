package com.example.security.service;

import com.example.security.dto.JoinDto;
import com.example.security.entity.UserEntity;
import com.example.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void joinProcess(JoinDto joinDto){

        System.out.println("회원 가입 로그 !!");

        //db에 이미 동일한 username을 가진 회원이 존재하는지?
        boolean isUser = userRepository.existsByUsername(joinDto.getUsername());
        if (isUser) {
            System.out.println("회원이 이미 존재 합니다.");
            return;
        }

        // 정보 입력
        UserEntity entity = new UserEntity();
        entity.setUsername(joinDto.getUsername());
        entity.setPassword(passwordEncoder.encode(joinDto.getPassword()));
        entity.setRole("ROLE_USER");

        userRepository.save(entity);
    }
}
