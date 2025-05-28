package com.locadora.cliente;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String cpf;
    private String contato;


}
