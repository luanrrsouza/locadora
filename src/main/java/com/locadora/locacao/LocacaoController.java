package com.locadora.locacao;

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
        return locacaoService.criarLocacao(locacao);
    }

    @GetMapping
    public List<Locacao> listarLocacoes() {
        return locacaoService.listarLocacoes();
    }

    @GetMapping("/{id}")
    public Locacao buscarPorId(@PathVariable Long id) {
        return locacaoService.buscarLocacaoPorId(id);
    }

    @PutMapping("/{id}")
    public Locacao atualizarLocacao(@PathVariable Long id, @RequestBody Locacao locacao) {
        return locacaoService.atualizarLocacao(id, locacao);
    }

    @DeleteMapping("/{id}")
    public void deletarLocacao(@PathVariable Long id) {
        locacaoService.deletarLocacao(id);
    }

    @PostMapping("/filme/{filmeId}")
    public Locacao locarFilme(@PathVariable Long filmeId, @RequestBody Locacao locacao) {
        return locacaoService.locarFilme(filmeId, locacao);
    }
}
