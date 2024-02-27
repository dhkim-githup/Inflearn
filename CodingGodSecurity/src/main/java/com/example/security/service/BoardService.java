package com.example.security.service;

import com.example.security.model.Board;
import com.example.security.model.User;
import com.example.security.repository.BoardRepo;
import com.example.security.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepo boardRepo;

    @Autowired
    private UserRepo userRepo;

    public Board doSave(String username , Board board){
            User user = userRepo.findByUsername(username);
            board.setUser(user);
            return boardRepo.save(board);
    }

}
