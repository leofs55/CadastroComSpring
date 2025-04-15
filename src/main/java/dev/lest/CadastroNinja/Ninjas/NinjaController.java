package dev.lest.CadastroNinja.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    // Adicionar ninja:

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + ninjaDTO.getNome() + " Id: " + ninjaDTO.getId());
    }

    // Procurar ninja por id:

    @GetMapping("/ninjas")
    public ResponseEntity<List<NinjaDTO>> mostrarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Mostrar Ninjas:

    @GetMapping("/ninjas/{id}")
    public ResponseEntity<?> mostrarNinja(@PathVariable long id) {
        return ninjaService.ninjaPorId(id);
    }

    // Alterar dados de ninja:

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinja(@RequestBody NinjaDTO ninja, @PathVariable long id) {
        return ninjaService.alterarNinja(ninja, id);
    }

    // Remover ninja:

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable long id) {
        return ninjaService.deletarNinjaPorId(id);
    }
}
