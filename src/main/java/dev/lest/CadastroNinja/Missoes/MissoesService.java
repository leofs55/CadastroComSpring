package dev.lest.CadastroNinja.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository repository;

    public MissoesService(MissoesRepository repository) {
        this.repository = repository;
    }

    public List<MissoesNinjaModel> listarMissoes(){
        return repository.findAll();
    }

    public MissoesNinjaModel buscarMissaoPorId(Long id) {
        Optional<MissoesNinjaModel> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public MissoesNinjaModel criarMissao(MissoesNinjaModel missao) {
        return repository.save(missao);
    }
}
