package dev.lest.CadastroNinja.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/")
    public String index() {
        return "Olá! ";
    }

    // Adicionar ninja:

    @PostMapping("/criar-ninja")
    public String criarNinja() {
        return "Ninja Criado";
    }

    // Procurar ninja por id:

    @GetMapping("/ninjas-cadastrados")
    public List<NinjaModel> mostrarNinjas() {

        return ninjaService.listarNinjas();
    }

    // Mostrar Ninjas:

    @GetMapping("/ninja-por-id")
    @ResponseBody
    public Optional<NinjaModel> mostrarNinja(@RequestParam(name = "id") Long id) {
        return ninjaService.ninjaPorId(id);
    }

    // Alterar dados de ninja:

    @PutMapping("/alterar")
    public String alterarNinja() {
        return "Ninja Criado";
    }

    // Remover ninja:

    @PostMapping("/deletar-id")
    public String deletarNinja() {
        return "Ninja Criado";
    }
}
