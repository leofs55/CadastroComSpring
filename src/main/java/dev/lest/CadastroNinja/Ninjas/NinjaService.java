package dev.lest.CadastroNinja.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    //NinjaDTO
    private final NinjaMapper ninjaMapper;
    private final NinjaRepository repository;

    public NinjaService(NinjaMapper ninjaMapper, NinjaRepository repository) {
        this.ninjaMapper = ninjaMapper;
        this.repository = repository;
    }

    public List<NinjaDTO> listarNinjasUi() {
        List<NinjaModel> ninjaModel = repository.findAll();
        return ninjaModel.stream()
                                .map(ninjaMapper::map)
                                .collect(Collectors.toList());
    }

    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaModel> ninjaModel = repository.findAll();
        List<NinjaDTO> ninjaDTOList =  ninjaModel.stream()
                                                .map(ninjaMapper::map)
                                                .collect(Collectors.toList());
        return ResponseEntity.ok(ninjaDTOList);
    }

    public ResponseEntity<?> ninjaPorId(long id) {
        Optional<NinjaModel> ninjaModel = repository.findById(id);
        if (ninjaModel.isPresent()) {
            return ResponseEntity.ok(ninjaModel.map(ninjaMapper::map).orElse(null));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja de id: "+ id + " não foi encontrado!");
    }

    public NinjaDTO criarNinja(NinjaDTO ninja){
        NinjaModel ninjaModel = ninjaMapper.map(ninja);
        ninjaModel = repository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    public ResponseEntity<String> deletarNinjaPorId(long id) {
        Optional<NinjaModel> ninjaExistente = repository.findById(id);
        if (ninjaExistente.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok("Ninja do id: " + id + " foi deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja de id: "+ id + " não foi encontrado!");
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
