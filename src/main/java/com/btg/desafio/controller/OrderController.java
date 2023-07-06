package com.btg.desafio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @GetMapping
    public ResponseEntity<Object> test(){
        return ResponseEntity.ok("Deu certo");
    }
}
