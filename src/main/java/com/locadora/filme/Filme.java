package com.locadora.filme;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.locadora.locacao.Locacao;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String genero;
    private Integer anoLancamento;
    private Boolean disponivel = true;
    private Double preco;

    @OneToMany(mappedBy = "filme", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Locacao> locacoes;
}
