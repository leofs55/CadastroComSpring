package dev.lest.CadastroNinja.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missao")
public class MissoesController {

    MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Adicionar ninja:

    @PostMapping("/criar")
    public MissoesNinjaModel criarMissao(@RequestBody MissoesNinjaModel missao) {
        return missoesService.criarMissao(missao);
    }

    // Procurar ninja por id:

    @GetMapping("/listar-missoes")
    public List<MissoesNinjaModel> mostrarMissoes() {
        return missoesService.listarMissoes();
    }

    // Mostrar Ninjas:

    @GetMapping("/missao-id/{id}")
    public MissoesNinjaModel mostrarMissao(@PathVariable Long id) {
        return missoesService.buscarMissaoPorId(id);
    }

    // Alterar dados de ninja:

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missao Criado";
    }

    // Remover ninja:

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
        missoesService.deletarMissaoPorId(id);
    }
}
