package br.edu.infnet.appRegistroProducao.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
@Setter
@Getter
@Entity
public class Artesao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArtesao;
    private String nome;
    private String cpf;
    @Transient
    private Map<String, NivelTecnicaENUM> tecnicas;
    @Transient
    private Map<String, String> dadosPagamento;
    private String telefone;

    @OneToMany(mappedBy = "artesao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producao> producao;

    @Override
    public String toString(){
        return String.format("nome (%s) - cpf (%s) - telefone (%s)", nome, cpf, telefone);
    }
}
