package com.example.securiyutest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class TestController {


    @GetMapping("/get")
    public ResponseEntity<?> getone() {
        return ResponseEntity.ok("Hello Guys");
    }

    @GetMapping("/get2")
    public ResponseEntity<?> gettwo() {
        return ResponseEntity.ok("Hello Guys2222");
    }


}


