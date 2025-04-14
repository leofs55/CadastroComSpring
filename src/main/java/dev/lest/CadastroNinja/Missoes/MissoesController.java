package dev.lest.CadastroNinja.Missoes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Adicionar ninja:

    @PostMapping("/criar")
    public ResponseEntity<MissoesDTO> criarMissao(@RequestBody MissoesDTO missao) {
        return missoesService.criarMissao(missao);
    }

    // Procurar ninja por id:

    @GetMapping("/missoes")
    public ResponseEntity<List<MissoesDTO>> mostrarMissoes() {
        return missoesService.listarMissoes();
    }

    // Mostrar Ninjas:

    @GetMapping("/missoes/{id}")
    public ResponseEntity<?> mostrarMissao(@PathVariable long id) {
        return missoesService.buscarMissaoPorId(id);
    }

    // Alterar dados de ninja:

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable long id, @RequestBody MissoesDTO missoesNinjaModel) {
        return  missoesService.alterarMissaoAntiga(missoesNinjaModel, id);
    }

    // Remover ninja:

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable long id) {
        return missoesService.deletarMissaoPorId(id);
    }
}
