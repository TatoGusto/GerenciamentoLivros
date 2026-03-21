package com.oatw.GerenciamentoLivros.Repositories;

import com.oatw.GerenciamentoLivros.Models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel,Long> {
}
