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

    @PostMapping("/cadastrar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Procurar ninja por id:

    @GetMapping("/listar-ninjas")
    public List<NinjaModel> mostrarNinjas() {

        return ninjaService.listarNinjas();
    }

    // Mostrar Ninjas:

    @GetMapping("/ninja-id/{id}")
    public NinjaModel mostrarNinja(@PathVariable Long id) {
        return ninjaService.ninjaPorId(id);
    }

    // Alterar dados de ninja:

    @PutMapping("/alterar")
    public String alterarNinja() {
        return "Ninja Criado";
    }

    // Remover ninja:

    @PostMapping("/deletar")
    public String deletarNinja() {
        return "Ninja Criado";
    }
}
