package com.example.security.controller;

import com.example.security.model.Board;
import com.example.security.repository.BoardRepo;
import com.example.security.validator.BoardValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardCon {

    @Autowired
    private BoardValidator boardValidator;

    @Autowired
    private BoardRepo boardRepo;

    @GetMapping("/list")
    public String doList(Model model){

        List<Board> boardList =  boardRepo.findAll();
        model.addAttribute("board", boardList);

        return "board/list";
    }

    @GetMapping("/form")
    public String doForm(Model model, @RequestParam(required = false) Long id){
        if(id==null){
            model.addAttribute("board", new Board());
        }else{
            Board board = boardRepo.findById(id).orElse(null);
            model.addAttribute("board", board);
        }

        return "board/form";
    }

    @PostMapping("/form")
    public String greetingSubmit(@Valid Board board, BindingResult bindingResult) {

        boardValidator.validate(board, bindingResult);

        if (bindingResult.hasErrors()) {
            return "board/form";
        }
        boardRepo.save(board);

        return "redirect:/board/list";
    }


}
