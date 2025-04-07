package dev.lest.CadastroNinja.Missoes;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_missoes")
public class MissoesNinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;


    public MissoesNinjaModel() {}

    public MissoesNinjaModel(long id, String nomeMissao, String dificuldadeMissao) {
        this.id = id;
        this.nome = nomeMissao;
        this.dificuldade = dificuldadeMissao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
}
