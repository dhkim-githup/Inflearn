package com.example.security.controller;

import com.example.security.model.Board;
import com.example.security.repository.BoardRepo;
import com.example.security.service.BoardService;
import com.example.security.validator.BoardValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String doList(Model model,
                         @PageableDefault(size = 4) Pageable pageable,
                         @RequestParam(required = false, defaultValue = "") String searchText){

        //List<Board> boardList =  boardRepo.findAll();
        //Page<Board> boardList =  boardRepo.findAll(PageRequest.of(0,2));

        //http://localhost:8080/board/list?page=0&size=3
        //Page<Board> boardList =  boardRepo.findAll(pageable);
        Page<Board> boardList =  boardRepo.findByTitleContainingOrContentContaining(searchText, searchText, pageable);

        int startPage = Math.max(1,boardList.getPageable().getPageNumber()-4);
        int endPage   = Math.min(boardList.getTotalPages(),boardList.getPageable().getPageNumber()+4);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

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
    public String greetingSubmit(@Valid Board board, BindingResult bindingResult, Authentication authentication) {

        boardValidator.validate(board, bindingResult);

        if (bindingResult.hasErrors()) {
            return "board/form";
        }
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        boardService.doSave(username, board);
        //boardRepo.save(board);

        return "redirect:/board/list";
    }


}
