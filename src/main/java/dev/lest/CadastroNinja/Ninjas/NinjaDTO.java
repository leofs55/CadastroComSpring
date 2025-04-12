package dev.lest.CadastroNinja.Ninjas;

import dev.lest.CadastroNinja.Missoes.MissoesNinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private long id;
    private String nome;
    private String email;
    private int idade;
    private String img_url;
    private String rank;
    private MissoesNinjaModel missoes;



}
