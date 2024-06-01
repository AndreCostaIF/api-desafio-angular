package com.example.desafio.services;

import com.example.desafio.model.User;
import com.example.desafio.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){

        return userRepository.findAll();
    }
}
