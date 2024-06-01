package com.example.desafio.repositories;

import com.example.desafio.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    @Query(value = "SELECT * FROM endereco where user_id = ?1", nativeQuery = true)
    public List<Endereco> findByUser(String id);
}
