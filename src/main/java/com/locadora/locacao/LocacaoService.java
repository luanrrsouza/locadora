package com.locadora.locacao;

import com.locadora.exception.ApiError.BadRequestException;
import com.locadora.exception.ApiError.NotFoundException;
import com.locadora.filme.Filme;
import com.locadora.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    public Locacao buscarLocacaoPorId(Long id) {
        return locacaoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Locação com id " + id + " não encontrada"));
    }

    public List<Locacao> listarLocacoes() {
        return locacaoRepository.findAll();
    }

    public Locacao criarLocacao(Locacao locacao) {
        if (locacao == null) {
            throw new BadRequestException("Dados da locação não podem ser nulos");
        }
        return locacaoRepository.save(locacao);
    }

    public Locacao atualizarLocacao(Long id, Locacao locacaoAtualizada) {
        if (locacaoAtualizada == null) {
            throw new BadRequestException("Dados para atualização são inválidos");
        }

        return locacaoRepository.findById(id)
                .map(locacao -> {
                    locacao.setDataLocacao(locacaoAtualizada.getDataLocacao());
                    locacao.setDataDevolucao(locacaoAtualizada.getDataDevolucao());
                    return locacaoRepository.save(locacao);
                })
                .orElseThrow(() -> new NotFoundException("Locação com id " + id + " não encontrada"));
    }

    public void deletarLocacao(Long id) {
        if (!locacaoRepository.existsById(id)) {
            throw new NotFoundException("Locação com id " + id + " não encontrada");
        }
        locacaoRepository.deleteById(id);
    }

    public Locacao locarFilme(Long filmeId, Locacao locacao) {
        Filme filme = filmeRepository.findById(filmeId)
                .orElseThrow(() -> new NotFoundException("Filme com id " + filmeId + " não encontrado"));

        if (!filme.getDisponivel()) {
            throw new BadRequestException("Filme não está disponível para locação");
        }

        filme.setDisponivel(false);
        filmeRepository.save(filme);

        return locacaoRepository.save(locacao);
    }
}
