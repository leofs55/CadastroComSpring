package dev.lest.CadastroNinja.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @GetMapping("/")
    public String index() {
        return "Olá! ";
    }

    // Adicionar ninja:

    @PostMapping("/criar-ninja")
    public String criarNinja() {
        return "Ninja Criado";
    }

    // Procurar ninja por id:

    @GetMapping("/ninjas-cadastrados")
    public String mostrarNinjas() {
        return "Ninja Criado";
    }

    // Mostrar Ninjas:

    @PostMapping("/ninja-por-id")
    public String mostrarNinja() {
        return "Ninja Criado";
    }

    // Alterar dados de ninja:

    @PutMapping("/alterar")
    public String alterarNinja() {
        return "Ninja Criado";
    }

    // Remover ninja:

    @PostMapping("/deletar-id")
    public String deletarNinja() {
        return "Ninja Criado";
    }
}
