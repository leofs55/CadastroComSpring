package dev.lest.CadastroNinja.Ninjas;

import dev.lest.CadastroNinja.Missoes.MissoesNinjaModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "idade")
    private int idade;


    @ManyToOne // Um ninja tem uma só missao
    @JoinColumn(name = "missoes_id") // Fk da missao
    private MissoesNinjaModel missoes;

}
// Transforma uma classe em Entidade do DB
