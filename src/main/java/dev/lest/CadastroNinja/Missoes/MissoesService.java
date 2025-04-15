package dev.lest.CadastroNinja.Missoes;

import dev.lest.CadastroNinja.Ninjas.NinjaModel;
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

    public List<MissoesDTO> listarMissoes(){
        List<MissoesNinjaModel> ninjaModelList = repository.findAll();
        return ninjaModelList.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO buscarMissaoPorId(long id) {
        Optional<MissoesNinjaModel> optional = repository.findById(id);
        return optional.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO criarMissao(MissoesDTO missao) {
        MissoesNinjaModel missoesNinjaModel = missoesMapper.map(missao);
        missoesNinjaModel = repository.save(missoesNinjaModel);
        return missoesMapper.map(missoesNinjaModel);
    }

    public void deletarMissaoPorId(long id) {
        repository.deleteById(id);
    }

    public MissoesDTO alterarMissaoAntiga(MissoesDTO missaoAtualizada, long id) {
        Optional<MissoesNinjaModel> missaoExistente = repository.findById(id);
        if (missaoExistente.isPresent()) {
            MissoesNinjaModel missaoNova = missoesMapper.map(missaoAtualizada);
            missaoNova.setId(id);
            MissoesNinjaModel missaoSalva = repository.save(missaoNova);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }
}
