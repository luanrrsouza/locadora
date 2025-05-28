package com.locadora.filme.service;

import com.locadora.filme.entity.Filme;
import com.locadora.filme.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public Filme salvar(Filme filme){
        return filmeRepository.save(filme);
    }

    public List<Filme> listarTodos(){
        return filmeRepository.findAll();
    }

    public Optional<Filme> buscarFilmePorId(Long id){
        return filmeRepository.findById(id);
    }

    public void deletarFilme(Long id){
        filmeRepository.deleteById(id);
    }


}
