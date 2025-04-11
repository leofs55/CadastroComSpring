package dev.lest.CadastroNinja.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository repository;

    public NinjaService(NinjaRepository repository) {
        this.repository = repository;
    }

    public List<NinjaModel> listarNinjas() {
        return repository.findAll();
    }

    public NinjaModel ninjaPorId(Long id) {
        Optional<NinjaModel> ninjaModel = repository.findById(id);
        return ninjaModel.orElse(null);
    }

    public NinjaModel criarNinja(NinjaModel ninja){
        return repository.save(ninja);
    }

    public void deletarNinjaPorId(Long id) {
        repository.deleteById(id);
    }


}
