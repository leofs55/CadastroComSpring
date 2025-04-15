package dev.lest.CadastroNinja.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Adicionar ninja:

    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missao) {
        return missoesService.criarMissao(missao);
    }

    // Procurar ninja por id:

    @GetMapping("/missoes")
    public List<MissoesDTO> mostrarMissoes() {
        return missoesService.listarMissoes();
    }

    // Mostrar Ninjas:

    @GetMapping("/missoes/{id}")
    public MissoesDTO mostrarMissao(@PathVariable long id) {
        return missoesService.buscarMissaoPorId(id);
    }

    // Alterar dados de ninja:

    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissao(@PathVariable long id, @RequestBody MissoesDTO missoesNinjaModel) {
        return  missoesService.alterarMissaoAntiga(missoesNinjaModel, id);
    }

    // Remover ninja:

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable long id) {
        missoesService.deletarMissaoPorId(id);
    }
}
