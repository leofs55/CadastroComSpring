package dev.lest.CadastroNinja.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaServiceUi ninjaService;

    public NinjaControllerUi(NinjaServiceUi ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String listarNinja(Model model) {
        List<NinjaDTO> ninjaDTOList = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjaDTOList);
        return "listarNinjas";
    }

    @GetMapping("/adicionar")
    public String criarNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarNinja";
    }

    @GetMapping("/listar/{id}")
    public String mostrarNinja(@PathVariable long id, Model model) {
        NinjaDTO ninjaDTO = ninjaService.ninjaPorId(id);
        if (ninjaDTO != null) {
            model.addAttribute("ninja", ninjaDTO);
            return "detalhesNinja";
        }else {
            model.addAttribute("mensagem", "ninja não encontrado");
            return "listarNinjas";
        }
    }

    // Remover ninja:

    @GetMapping("/deletar/{id}")
    public String deletarNinja(@PathVariable long id) {
        return ninjaService.deletarNinjaPorId(id);
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.criarNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso!");
        return "redirect:/ninjas/ui/listar";
    }
}
