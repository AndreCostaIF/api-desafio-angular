package com.example.desafio.controller;


import com.example.desafio.model.Endereco;
import com.example.desafio.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@ResponseBody //RETURN JSON
//@CrossOrigin(originPatterns = "http://localhost/moduloRh/public/", allowCredentials = "true")
@RequestMapping(path = "/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Endereco>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findAll());
    }
    //SAVE PAYMENT

    @PostMapping(path = "/save")
    public ResponseEntity<Endereco> save(@RequestBody Endereco endereco){

        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(endereco));
    }

    //FIND BY ID
    @GetMapping(path = "/user/{id}")
    public ResponseEntity<List<Endereco>> findByUser(@PathVariable String id){

        List<Endereco> enderecos = enderecoService.findByUser(id);

        if(enderecos != null){
            return ResponseEntity.status(HttpStatus.OK).body(enderecos);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    //FIND BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<Endereco> find(@PathVariable Long id){

        Endereco endereco = enderecoService.findById(id);

        if(endereco != null){
            return ResponseEntity.status(HttpStatus.OK).body(endereco);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable  Long id){
        if(enderecoService.findById(id) != null){
            enderecoService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Endereço deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço Não existe!");
        }
    }
}
