package com.locadora.locacao.controller;


import com.locadora.locacao.entity.Locacao;
import com.locadora.locacao.service.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    @PostMapping
    public Locacao salvarLocacao(@RequestBody Locacao locacao) {
        return locacaoService.salvarLocacao(locacao);
    }

    @GetMapping
    public List<Locacao> listar() {
        return locacaoService.listar();
    }
}
