package com.example.desafio.dto;

import com.example.desafio.model.Endereco;

import java.util.List;

public record ResponseDTO (String id, String name, String email, String token, List<Endereco> enderecos){

}
