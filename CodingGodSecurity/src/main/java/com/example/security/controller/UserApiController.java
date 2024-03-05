package com.example.security.controller;

import com.example.security.model.Board;
import com.example.security.model.User;
import com.example.security.repository.UserRepo;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/api")
class UserApiController {

    @Autowired
    private UserRepo repository;

    @GetMapping("/users")
    List<User> doAll(@RequestParam(required = false) String method, @RequestParam(required = false) String text){

        List<User> users = null;

        if("query".equals(method)) {
            users = repository.findByUsernameQuery(text);
        } else if("nativeQuery".equals(method)) {
            users = repository.findByUsernameNativeQuery(text);
        } else if("querydsl".equals(method)) {
//            QUser user = QUser.user();
//            Predicate predicate = user.firstname.equalsIgnoreCase("dave")
//                    .and(user.lastname.startsWithIgnoreCase("mathews"));
//
//            repository.findAll(predicate);
        }else {
            users = repository.findAll();
        }

        return  users;
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    // Single item

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

        return repository.findById(id)
                .map(user -> {
//                    user.setTitle(newUser.getTitle());
//                    user.setContent(newUser.getContent());
                    user.setBoards(newUser.getBoards());

                    for(Board board : user.getBoards()){
                        board.setUser(user);
                    }

                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}