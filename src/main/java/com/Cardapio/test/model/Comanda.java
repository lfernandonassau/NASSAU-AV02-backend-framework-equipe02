package com.Cardapio.test.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "tb_comandas")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numeroMesa; // Ex: Mesa 10

    private String nomeCliente; // Ex: "Gustavo"

    private Boolean estaAberta = true; // Quando criar, já nasce aberta

    // RELACIONAMENTO: Uma comanda tem vários itens
    // mappedBy = "comanda" refere-se ao atributo 'comanda' lá na classe ItemComanda
    @OneToMany(mappedBy = "comanda", cascade = CascadeType.ALL)
    private List<ItemComanda> itens = new ArrayList<>();

    // --- CONSTRUTOR VAZIO (Obrigatório para o JPA) ---
    public Comanda() {
    }

    // --- GETTERS E SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getNumeroMesa() { return numeroMesa; }
    public void setNumeroMesa(Integer numeroMesa) { this.numeroMesa = numeroMesa; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public Boolean getEstaAberta() { return estaAberta; }
    public void setEstaAberta(Boolean estaAberta) { this.estaAberta = estaAberta; }

    public List<ItemComanda> getItens() { return itens; }
    public void setItens(List<ItemComanda> itens) { this.itens = itens; }
}