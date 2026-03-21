package com.oatw.GerenciamentoLivros.Controllers;

import com.oatw.GerenciamentoLivros.Models.LivroModel;
import com.oatw.GerenciamentoLivros.Services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/livros")
public class LivroController {

    @Autowired
    LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroModel> createLivro(@RequestBody LivroModel livroModel) {
        LivroModel request = livroService.createLivro(livroModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(livroModel.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<LivroModel>> findAll() {
        List<LivroModel> request = livroService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroModel> findById(@PathVariable Long id) {
        LivroModel Request = livroService.getById(id);
        return ResponseEntity.ok().body(Request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLivro(@PathVariable Long id) {
        livroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
