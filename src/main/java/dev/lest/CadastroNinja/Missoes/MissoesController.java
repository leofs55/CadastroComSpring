package dev.lest.CadastroNinja.Missoes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MissoesController {

    @GetMapping("/missoes")
    public String missoesHome() {
        return "Pagina de missoes!";
    }
}
