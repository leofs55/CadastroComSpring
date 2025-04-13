package dev.lest.CadastroNinja.Ninjas;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    //NinjaDTO
    private NinjaMapper ninjaMapper;
    private NinjaRepository repository;

    public NinjaService(NinjaMapper ninjaMapper, NinjaRepository repository) {
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
        return ninjaModel.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninja){
        NinjaModel ninjaModel = ninjaMapper.map(ninja);
        ninjaModel = repository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    public void deletarNinjaPorId(long id) {
        repository.deleteById(id);
    }

    public NinjaDTO alterarNinja(NinjaDTO ninja, long id){
        Optional<NinjaModel> ninjaExistente = repository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninja);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = repository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

}
