package com.example.securiyutest.controller;

import com.example.securiyutest.model.User;
import com.example.securiyutest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity create(@RequestBody User user) {
        if (userService.existUser(user.getLogin())) {
            return new ResponseEntity<>("Login is exist", HttpStatus.BAD_REQUEST);
        }
        if (checkPasswordLength(user.getPassword())){
            return new ResponseEntity("parol uzunliki 4 dan kam", HttpStatus.BAD_REQUEST);
        }
        User result = userService.save(user);
        return ResponseEntity.ok(result);

    }

    private Boolean checkPasswordLength(String password) {
        return password.length() <= 4;
    }
}
