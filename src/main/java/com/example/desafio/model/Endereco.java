package com.example.desafio.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name= "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @NonNull
    @Column
    private String rua;
    @NonNull
    @Column
    private String numero;
    @NonNull
    @Column
    private String bairro;
    @NonNull
    @Column
    private String complemento;
    @NonNull
    @Column
    private String cidade;

    @NonNull
    @Column
    private String cep;

    @NonNull
    @Column
    private String uf;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
