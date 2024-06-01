package com.example.desafio.controller;

import com.example.desafio.model.User;
import com.example.desafio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@ResponseBody //RETURN JSON

@RestController
@RequestMapping(path = "/user")

public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<User>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping(path = "/teste")
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("sucesso!");
    }

}
