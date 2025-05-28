package com.locadora.filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @PostMapping
    public Filme salvarFilme(@RequestBody Filme filme) {
        return filmeService.salvarFilme(filme);
    }

    @GetMapping
    public List<Filme> listarFilmes() {
        return filmeService.listarFilmes();
    }

    @GetMapping("/{id}")
    public Filme buscarFilmePorId(@PathVariable Long id) {
        return filmeService.buscarFilmePorId(id);
    }

    @PutMapping("/{id}")
    public Filme atualizarFilme(@PathVariable Long id, @RequestBody Filme filme) {
        return filmeService.atualizarFilme(id, filme);
    }

    @DeleteMapping("/{id}")
    public void deletarFilme(@PathVariable Long id) {
        filmeService.deletarFilme(id);
    }
}
