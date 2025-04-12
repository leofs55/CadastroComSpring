package dev.lest.CadastroNinja.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    //NinjaDTO
    private NinjaMapper ninjaMapper;
    private NinjaRepository repository;

    public NinjaService(NinjaMapper ninjaMapper, NinjaRepository repository) {
        this.ninjaMapper = ninjaMapper;
        this.repository = repository;
    }

    public List<NinjaModel> listarNinjas() {
        return repository.findAll();
    }

    public NinjaModel ninjaPorId(long id) {
        Optional<NinjaModel> ninjaModel = repository.findById(id);
        return ninjaModel.orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninja){
        NinjaModel ninjaModel = ninjaMapper.map(ninja);
        ninjaModel = repository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    public void deletarNinjaPorId(long id) {
        repository.deleteById(id);
    }

    public NinjaModel alterarNinja(NinjaModel ninja, long id){
        if (repository.existsById(id)) {
            ninja.setId(id);
            return repository.save(ninja);
        }
        return null;
    }

}
