package com.locadora.filme.controller;

import com.locadora.filme.entity.Filme;
import com.locadora.filme.repository.FilmeRepository;
import com.locadora.filme.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeService filmeService;

    @PostMapping
    public Filme save(@RequestBody Filme filme) {
        return filmeService.salvar(filme);
    }

    @GetMapping
    public List<Filme> listarTodos() {
        return filmeService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Filme> buscarPorId(@PathVariable Long id) {
        return filmeService.buscarFilmePorId(id);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        filmeService.deletarFilme(id);
    }

    @PutMapping("/{id}")
    public Filme atualizar(@PathVariable Long id, @RequestBody Filme filme) {
        filme.setId(id);
        return filmeService.salvar(filme);
    }
}
