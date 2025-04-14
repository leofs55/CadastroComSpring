package dev.lest.CadastroNinja.Missoes;

import dev.lest.CadastroNinja.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesDTO {

    private long id;
    private String nome;
    private String dificuldade;
    private List<NinjaModel> ninjas;

}
