package com.locadora.locacao.service;


import com.locadora.locacao.entity.Locacao;
import com.locadora.locacao.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepository;

    public Locacao salvarLocacao(Locacao locacao) {
        return locacaoRepository.save(locacao);
    }

    public List<Locacao> listar() {
        return locacaoRepository.findAll();
    }

    public Optional<Locacao> buscarPorId(Long id) {
        return locacaoRepository.findById(id);
    }

    public void deletar(Long id) {
        locacaoRepository.deleteById(id);
    }
}
