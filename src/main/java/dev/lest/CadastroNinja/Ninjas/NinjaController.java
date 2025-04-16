package dev.lest.CadastroNinja.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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



    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um ninja e insere no banco de dados")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja.")
    })
    public ResponseEntity<String> criarNinja(@Parameter(description = "Usuario manda um objeto no body da requisicao")
                                             @RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + ninjaDTO.getNome() + " Id: " + ninjaDTO.getId());
    }

    // Adicionar ninja:
    // Procurar ninja por id:

    @GetMapping("/ninjas")
    @Operation(summary = "Listagem de dados",description = "Essa rota retorna todos os ninjas cadastrados")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "Ninjas achados com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado!")
    })
    public ResponseEntity<List<NinjaDTO>> mostrarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Mostrar Ninjas:

    @GetMapping("/ninjas/{id}")
    @Operation(summary = "Listagem de dados individuais", description = "Esssa rota retorna os dados de um ninjas específico")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "Ninja buscado com sucesso!"),
            @ApiResponse(responseCode = "403", description = "Ninja não encontrado!")
    })
    public ResponseEntity<?> mostrarNinja(@Parameter(description = "Usuario manda o id no caminho da requisiçao")
                                          @PathVariable long id) {
        return ninjaService.ninjaPorId(id);
    }

    // Alterar dados de ninja:

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera um ninja cadastrado", description = "Rota busca e altera os dados de um ninja cadastrado!")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "201", description = "Ninja alterado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado!")
    })
    public ResponseEntity<?> alterarNinja(@Parameter(description = "Usuario manda um objeto no body da requisicao")
                                          @RequestBody NinjaDTO ninja,
                                          @Parameter(description = "Usuario manda o id no caminho da requisiçao")
                                          @PathVariable long id) {
        return ninjaService.alterarNinja(ninja, id);
    }

    // Remover ninja:

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta um ninja cadastrado por id.", description = "Rota busca e deleta um ninja do banco de dados!")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "201", description = "Ninja deletado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado!")
    })
    public ResponseEntity<String> deletarNinja(@Parameter(description = "Usuario manda o id no caminho da requisiçao")
                                               @PathVariable long id) {
        return ninjaService.deletarNinjaPorId(id);
    }
}
