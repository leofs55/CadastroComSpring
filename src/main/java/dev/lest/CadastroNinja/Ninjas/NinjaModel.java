package dev.lest.CadastroNinja.Ninjas;

import dev.lest.CadastroNinja.Missoes.MissoesNinjaModel;
import jakarta.persistence.*;

import java.util.List;


// Transforma uma classe em Entidade do DB
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;
    @ManyToOne // Um ninja tem uma só missao
    @JoinColumn(name = "missoes_id") // Fk da missao
    private MissoesNinjaModel missoes;

    public NinjaModel() {}

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
