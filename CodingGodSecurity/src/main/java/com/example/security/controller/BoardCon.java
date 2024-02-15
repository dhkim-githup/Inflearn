package com.example.security.controller;

import com.example.security.model.Board;
import com.example.security.repository.BoardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardCon {

    @Autowired
    private BoardRepo boardRepo;

    @GetMapping("/list")
    public String doList(Model model){

        List<Board> boardList =  boardRepo.findAll();

        model.addAttribute("board", boardList);

        return "board/list";

    }
}
