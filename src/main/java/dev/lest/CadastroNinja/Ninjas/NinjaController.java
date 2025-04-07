package dev.lest.CadastroNinja.Ninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NinjaController {

    @GetMapping("/")
    public String index() {
        return "Olá! ";
    }
}
