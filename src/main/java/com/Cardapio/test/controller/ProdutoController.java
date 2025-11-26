package com.Cardapio.test.controller;

import com.Cardapio.test.model.Produto;
import com.Cardapio.test.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    // LISTAS PRODUTOS (GET)
    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    // CADASTRAR PRODUTO (POST)
    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto) {
        return repository.save(produto);
    }
}