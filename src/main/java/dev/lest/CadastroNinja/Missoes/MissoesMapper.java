package dev.lest.CadastroNinja.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesDTO map(MissoesNinjaModel missoesNinjaModel) {

        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesNinjaModel.getId());
        missoesDTO.setDificuldade(missoesNinjaModel.getDificuldade());
        missoesDTO.setNome(missoesNinjaModel.getNome());
        missoesDTO.setNinjas(missoesNinjaModel.getNinjas());

        return missoesDTO;
    }

    public MissoesNinjaModel map(MissoesDTO missoesDTO) {

        MissoesNinjaModel missoesNinjaModel = new MissoesNinjaModel();
        missoesNinjaModel.setId(missoesDTO.getId());
        missoesNinjaModel.setDificuldade(missoesDTO.getDificuldade());
        missoesNinjaModel.setNome(missoesDTO.getNome());
        missoesNinjaModel.setNinjas(missoesDTO.getNinjas());

        return missoesNinjaModel;
    }
}
