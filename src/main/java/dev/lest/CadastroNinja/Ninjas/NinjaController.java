package dev.lest.CadastroNinja.Ninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NinjaController {

    @GetMapping("/ninja")
    public String index() {
        return "Olá! ";
    }

    // Adicionar ninja:

    @PostMapping("/ninja/criar")
    public String criarNinja() {
        return "Ninja Criado";
    }

    // Procurar ninja por id:

    @GetMapping("/ninja/ninjas-cadastrados")
    public String mostrarNinjas() {
        return "Ninja Criado";
    }

    // Mostrar Ninjas:

    @PostMapping("/ninja/ninja-por-id")
    public String mostrarNinja() {
        return "Ninja Criado";
    }

    // Alterar dados de ninja:

    @PutMapping("/ninja/alterar")
    public String alterarNinja() {
        return "Ninja Criado";
    }

    // Remover ninja:

    @PostMapping("/ninja/deletar-id")
    public String deletarNinja() {
        return "Ninja Criado";
    }
}
