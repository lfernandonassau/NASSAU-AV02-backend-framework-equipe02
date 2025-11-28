package com.Cardapio.test;

import com.Cardapio.test.model.Comanda;
import com.Cardapio.test.model.Produto;
import com.Cardapio.test.repository.ComandaRepository;
import com.Cardapio.test.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CargaDeDados {

    @Bean
    public CommandLineRunner executar(ProdutoRepository produtoRepository, ComandaRepository comandaRepository) {
        return args -> {

            if (produtoRepository.count() == 0) {

                System.out.println("⚠️ Banco vazio ou novo! Carregando dados iniciais...");


                Produto p1 = new Produto();
                p1.setNome("X-Bacon");
                p1.setPreco(25.00);
                p1.setDescricao("Pão brioche, 2 carnes de 150g e muito bacon.");
                produtoRepository.save(p1);

                Produto p2 = new Produto();
                p2.setNome("Coca-Cola Lata");
                p2.setPreco(6.00);
                p2.setDescricao("350ml bem gelada.");
                produtoRepository.save(p2);

                Produto p3 = new Produto();
                p3.setNome("Batata Frita");
                p3.setPreco(18.50);
                p3.setDescricao("Porção grande com cheddar e bacon.");
                produtoRepository.save(p3);

                // 2. ABRIR UMA MESA DE TESTE
                Comanda c1 = new Comanda();
                c1.setNumeroMesa(10);
                c1.setNomeCliente("Professor (Teste)");
                c1.setEstaAberta(true);
                comandaRepository.save(c1);

                System.out.println("✅ DADOS INICIAIS SALVOS COM SUCESSO!");
            } else {
                System.out.println("✅ O banco já tem dados salvos. Iniciando sem alterar nada.");
            }
        };
    }
}