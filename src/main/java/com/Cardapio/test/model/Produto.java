package com.Cardapio.test.model;

import jakarta.persistence.*;

@Entity // Isso diz pro Spring: "Crie uma tabela disso no banco"
@Table(name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O ID vai ser automático (1, 2, 3...)
    private Long id;

    private String nome;

    private Double preco;

    private String descricao;

    private String categoria; // Ex: "Bebida", "Lanche"

    private String imagemUrl; // Link da foto do lanche

    // --- CONSTRUTORES, GETTERS E SETTERS ---
    // (O Spring precisa disso para funcionar)

    public Produto() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getImagemUrl() { return imagemUrl; }
    public void setImagemUrl(String imagemUrl) { this.imagemUrl = imagemUrl; }
}