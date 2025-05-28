package com.locadora.locacao.entity;

import com.locadora.cliente.entity.Cliente;
import com.locadora.filme.entity.Filme;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Locacao {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Filme filme;

    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
}
