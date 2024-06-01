package com.example.desafio.controller;

import com.example.desafio.dto.LoginRequestDTO;
import com.example.desafio.dto.RegisterRequestDTO;
import com.example.desafio.dto.ResponseDTO;
import com.example.desafio.model.Endereco;
import com.example.desafio.model.User;
import com.example.desafio.repositories.UserRepository;
import com.example.desafio.security.TokenService;
import com.example.desafio.services.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final TokenService tokenService;

    private final EnderecoService enderecoService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        User user = this.repository.findByEmail(body.email()).orElseThrow( () -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(body.password(),user.getPassword())){
            String token = this.tokenService.generateToken(user);

            List<Endereco> enderecos = enderecoService.findByUser(user.getId());

            return ResponseEntity.ok(new ResponseDTO(user.getId(), user.getName(), user.getEmail(), token, enderecos));
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){

        Optional<User> user = this.repository.findByEmail(body.email());

        if (user.isEmpty()){

            User newUser = new User();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setEmail(body.email());
            newUser.setName(body.name());

            this.repository.save(newUser);

            String token = this.tokenService.generateToken(newUser);

            return ResponseEntity.ok(new ResponseDTO(newUser.getId(), newUser.getName(), newUser.getEmail(), token, null));


        }
        return ResponseEntity.badRequest().build();
    }

}
