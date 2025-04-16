package dev.lest.CadastroNinja.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaServiceUi {

    //NinjaDTO
    private final NinjaMapper ninjaMapper;
    private final NinjaRepository repository;

    public NinjaServiceUi(NinjaMapper ninjaMapper, NinjaRepository repository) {
        this.ninjaMapper = ninjaMapper;
        this.repository = repository;
    }

    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjaModel = repository.findAll();
        return ninjaModel.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO ninjaPorId(long id) {
        Optional<NinjaModel> ninjaModel = repository.findById(id);
        if (ninjaModel.isPresent()) {
            return ninjaModel.map(ninjaMapper::map).orElse(null);
        }
        return null;
    }

    public NinjaDTO criarNinja(NinjaDTO ninja){
        NinjaModel ninjaModel = ninjaMapper.map(ninja);
        ninjaModel = repository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    public String deletarNinjaPorId(long id) {
        Optional<NinjaModel> ninjaExistente = repository.findById(id);
        repository.delete(ninjaExistente.get());
        return "redirect:/ninjas/ui/listar";
    }

    public ResponseEntity<?> alterarNinja(NinjaDTO ninja, long id){
        Optional<NinjaModel> ninjaExistente = repository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninja);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = repository.save(ninjaAtualizado);
            return ResponseEntity.ok(ninjaSalvo);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja de id: "+ id + " não foi encontrado!");
    }

}
