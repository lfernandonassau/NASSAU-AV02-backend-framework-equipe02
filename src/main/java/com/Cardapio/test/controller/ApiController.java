package com.Cardapio.test.controller; // <--- MUDOU AQUI (Adicionei o .controller)

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ApiController {

    @GetMapping("/mensagem")
    public String getMensagem() {
        return "Dados do Back-End Spring Boot funcionando!";
    }

    @PostMapping("/dados")
    public String postDados(@RequestBody String dados) {
        return "Recebido no Java: " + dados;
    }
}