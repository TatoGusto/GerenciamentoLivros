package com.oatw.GerenciamentoLivros.Services;

import com.oatw.GerenciamentoLivros.Models.LivroModel;
import com.oatw.GerenciamentoLivros.Repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    public LivroModel createLivro(LivroModel livroModel) {
        return livroRepository.save(livroModel);
    }

    public List<LivroModel> findAll() {
        return livroRepository.findAll();
    }

    public LivroModel getById(Long id) {
        return livroRepository.findById(id).get();
    }

    public void delete(LivroModel livroModel) {
        livroRepository.delete(livroModel);
    }
}
