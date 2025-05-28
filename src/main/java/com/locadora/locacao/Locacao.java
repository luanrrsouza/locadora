package com.locadora.locacao;

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
    @GeneratedValue( strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Filme filme;

    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
}
