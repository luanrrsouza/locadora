package com.locadora.filme;

import com.locadora.exception.ApiError.BadRequestException;
import com.locadora.exception.ApiError.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public Filme salvarFilme(Filme filme) {
        if (filme == null) {
            throw new BadRequestException("Filme não pode ser nulo");
        }
        return filmeRepository.save(filme);
    }

    public List<Filme> listarFilmes() {
        return filmeRepository.findAll();
    }

    public Filme buscarFilmePorId(Long id) {
        return filmeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Filme com id " + id + " não encontrado"));
    }

    public Filme atualizarFilme(Long id, Filme filmeAtualizado) {
        if (filmeAtualizado == null) {
            throw new BadRequestException("Dados para atualização são inválidos");
        }

        return filmeRepository.findById(id)
                .map(filme -> {
                    filme.setTitulo(filmeAtualizado.getTitulo());
                    filme.setGenero(filmeAtualizado.getGenero());
                    filme.setAnoLancamento(filmeAtualizado.getAnoLancamento());
                    filme.setPreco(filmeAtualizado.getPreco());
                    filme.setDisponivel(filmeAtualizado.getDisponivel());
                    return filmeRepository.save(filme);
                })
                .orElseThrow(() -> new NotFoundException("Filme com id " + id + " não encontrado"));
    }

    public void deletarFilme(Long id) {
        if (!filmeRepository.existsById(id)) {
            throw new NotFoundException("Filme com id " + id + " não encontrado");
        }
        filmeRepository.deleteById(id);
    }
}
