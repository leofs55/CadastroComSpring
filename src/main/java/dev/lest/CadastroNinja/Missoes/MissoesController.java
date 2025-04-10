package dev.lest.CadastroNinja.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missao")
public class MissoesController {

    // Adicionar ninja:

    @PostMapping("/criar/")
    public String criarMissao() {
        return "Missao Criado";
    }

    // Procurar ninja por id:

    @GetMapping("/listar-missoes")
    public String mostrarMissoes() {
        return "Missao Criado";
    }

    // Mostrar Ninjas:

    @PostMapping("/missao-id/{id]")
    public String mostrarMissao() {
        return "Missao Criado";
    }

    // Alterar dados de ninja:

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missao Criado";
    }

    // Remover ninja:

    @PostMapping("/deletar")
    public String deletarMissao() {
        return "Missao Criado";
    }
}
