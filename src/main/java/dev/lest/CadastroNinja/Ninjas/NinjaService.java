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

    public Optional<NinjaModel> ninjaPorId(Long id) {
        return repository.findById(id);
    }
}
