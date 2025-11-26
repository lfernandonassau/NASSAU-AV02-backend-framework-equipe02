package com.Cardapio.test.controller;

import com.Cardapio.test.model.Comanda;
import com.Cardapio.test.model.ItemComanda;
import com.Cardapio.test.model.Produto;
import com.Cardapio.test.repository.ComandaRepository;
import com.Cardapio.test.repository.ItemComandaRepository;
import com.Cardapio.test.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/comandas")
@CrossOrigin("*")
public class ComandaController {

    @Autowired
    private ComandaRepository comandaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemComandaRepository itemRepository;

    // Listar
    @GetMapping
    public List<Comanda> listarComandas() {
        return comandaRepository.findAll();
    }

    // abrir 1 mesa
    @PostMapping("/abrir")
    public Comanda abrirComanda(@RequestBody Comanda novaComanda) {
        novaComanda.setEstaAberta(true);
        return comandaRepository.save(novaComanda);
    }


    @PostMapping("/{idComanda}/adicionar/{idProduto}")
    public Comanda adicionarItem(@PathVariable Long idComanda, @PathVariable Long idProduto) {

        Comanda comanda = comandaRepository.findById(idComanda).orElseThrow();
        Produto produto = produtoRepository.findById(idProduto).orElseThrow();

        // criar os itens
        ItemComanda novoItem = new ItemComanda();
        novoItem.setProduto(produto);
        novoItem.setComanda(comanda);
        novoItem.setQuantidade(1);

        // save do banco de dados
        itemRepository.save(novoItem);

        // comanda quando att
        return comandaRepository.findById(idComanda).orElseThrow();
    }

    // --- NOVO: FECHAR A CONTA ---
    @PostMapping("/{id}/fechar")
    public Comanda fecharComanda(@PathVariable Long id) {
        Comanda comanda = comandaRepository.findById(id).orElseThrow();

        comanda.setEstaAberta(false); // Marca como fechada

        return comandaRepository.save(comanda);
    }

}