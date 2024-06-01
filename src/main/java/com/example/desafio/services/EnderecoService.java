package com.example.desafio.services;


import com.example.desafio.model.Endereco;
import com.example.desafio.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

    public List<Endereco> findAll(){


        return enderecoRepository.findAll();
    }

    public Endereco save(Endereco endereco){

        return enderecoRepository.save(endereco);
    }

    public Endereco update(Endereco endereco){

        return enderecoRepository.save(endereco);
    }

    public List<Endereco> findByUser(String id){
        List<Endereco> enderecos = enderecoRepository.findByUser(id);

        if(enderecos != null){
            return enderecos;
        }else{
            return null;
        }
    }

    public Endereco findById(Long id){
        if(enderecoRepository.findById(id).isPresent()){
            return enderecoRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //DELETE CLIENT
    public void  delete(Long id){
        enderecoRepository.deleteById(id);
    }
}
