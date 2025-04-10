package dev.lest.CadastroNinja.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missao")
public class MissoesController {

    @GetMapping("/")
    public String missoesHome() {
        return "<h1> Oi</h1>";
    }

    // Adicionar ninja:

    @PostMapping("/criar-missao")
    public String criarMissao() {
        return "Missao Criado";
    }

    // Procurar ninja por id:

    @GetMapping("missoes-cadastradas")
    public String mostrarMissoes() {
        return "Missao Criado";
    }

    // Mostrar Ninjas:

    @PostMapping("/missao-por-id")
    public String mostrarMissao() {
        return "Missao Criado";
    }

    // Alterar dados de ninja:

    @PutMapping("/alterar-id")
    public String alterarMissao() {
        return "Missao Criado";
    }

    // Remover ninja:

    @PostMapping("/deletar-id")
    public String deletarMissao() {
        return "Missao Criado";
    }
}
