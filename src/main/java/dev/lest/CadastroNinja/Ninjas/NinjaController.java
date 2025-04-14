package dev.lest.CadastroNinja.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    // Adicionar ninja:

    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Procurar ninja por id:

    @GetMapping("/ninjas")
    public List<NinjaDTO> mostrarNinjas() {

        return ninjaService.listarNinjas();
    }

    // Mostrar Ninjas:

    @GetMapping("/ninjas/{id}")
    public NinjaDTO mostrarNinja(@PathVariable long id) {
        return ninjaService.ninjaPorId(id);
    }

    // Alterar dados de ninja:

    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinja(@RequestBody NinjaDTO ninja, @PathVariable long id) {
        return ninjaService.alterarNinja(ninja, id);
    }

    // Remover ninja:

    @DeleteMapping("/deletar/{id}")
    public void deletarNinja(@PathVariable long id) {
        ninjaService.deletarNinjaPorId(id);
    }
}
