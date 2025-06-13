package com.locadora.locacao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.locadora.cliente.Cliente;
import com.locadora.filme.Filme;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Cliente cliente;

    @ManyToOne
    @JsonBackReference
    private Filme filme;

    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
}