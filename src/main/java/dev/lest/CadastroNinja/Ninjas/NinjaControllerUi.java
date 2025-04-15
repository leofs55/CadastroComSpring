package dev.lest.CadastroNinja.Ninjas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String listarNinja(Model model) {
        List<NinjaDTO> ninjaDTOList = ninjaService.listarNinjasUi();
        model.addAttribute("ninjas", ninjaDTOList);
        return "listarNinjas";
    }
}
