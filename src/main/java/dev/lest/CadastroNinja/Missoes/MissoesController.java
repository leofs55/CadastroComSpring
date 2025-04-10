package dev.lest.CadastroNinja.Missoes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MissoesController {

    @GetMapping("/missao")
    public String missoesHome() {
        return "Pagina de missoes!";
    }

    // Adicionar ninja:

    @PostMapping("/missao/criar")
    public String criarMissao() {
        return "Missao Criado";
    }

    // Procurar ninja por id:

    @GetMapping("/missao/missao-cadastrados")
    public String mostrarMissoes() {
        return "Missao Criado";
    }

    // Mostrar Ninjas:

    @PostMapping("/missao/missao-por-id")
    public String mostrarMissao() {
        return "Missao Criado";
    }

    // Alterar dados de ninja:

    @PutMapping("/missao/alterar")
    public String alterarMissao() {
        return "Missao Criado";
    }

    // Remover ninja:

    @PostMapping("/missao/deletar-id")
    public String deletarMissao() {
        return "Missao Criado";
    }
}
