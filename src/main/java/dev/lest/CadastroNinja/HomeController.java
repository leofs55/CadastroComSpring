package dev.lest.CadastroNinja;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "Bem vindo ao sistema para gerenciamento de ninjas.";
    }
}
