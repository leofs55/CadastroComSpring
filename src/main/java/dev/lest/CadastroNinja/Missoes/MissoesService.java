package dev.lest.CadastroNinja.Missoes;

import dev.lest.CadastroNinja.Ninjas.NinjaModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesMapper missoesMapper;
    private final MissoesRepository repository;

    public MissoesService(MissoesRepository repository, MissoesMapper missoesMapper) {
        this.repository = repository;
        this.missoesMapper = missoesMapper;
    }

    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesNinjaModel> ninjaModelList = repository.findAll();
        List<MissoesDTO> missoesDTOList = ninjaModelList.stream()
                                                            .map(missoesMapper::map)
                                                            .collect(Collectors.toList());
        return ResponseEntity.ok(missoesDTOList);
    }

    public ResponseEntity<?> buscarMissaoPorId(long id) {
        Optional<MissoesNinjaModel> optional = repository.findById(id);
        if (optional.isPresent()) {
            MissoesDTO missoesDTO = optional.map(missoesMapper::map).get();
            return ResponseEntity.ok(missoesDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("A missão de id: "+ id + " não foi encontrada!");
    }

    public ResponseEntity<MissoesDTO> criarMissao(MissoesDTO missao) {
        MissoesNinjaModel missoesNinjaModel = missoesMapper.map(missao);
        missoesNinjaModel = repository.save(missoesNinjaModel);
        MissoesDTO missoesDTO = missoesMapper.map(missoesNinjaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(missoesDTO);
    }

    public ResponseEntity<String> deletarMissaoPorId(long id) {
        Optional<MissoesNinjaModel> missaoExistente = repository.findById(id);
        if (missaoExistente.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok("Missão com id: " + id + " foi deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("A missão de id: "+ id + " não foi encontrada!");
    }

    public ResponseEntity<?> alterarMissaoAntiga(MissoesDTO missaoAtualizada, long id) {
        Optional<MissoesNinjaModel> missaoExistente = repository.findById(id);
        if (missaoExistente.isPresent()) {
            MissoesNinjaModel missaoNova = missoesMapper.map(missaoAtualizada);
            missaoNova.setId(id);
            MissoesNinjaModel missaoSalva = repository.save(missaoNova);
            MissoesDTO missoesDTO = missoesMapper.map(missaoSalva);
            return ResponseEntity.ok("");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("A missão de id: "+ id + " não foi encontrada!");
    }
}
