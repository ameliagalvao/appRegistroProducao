package br.edu.infnet.appRegistroProducao.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    //private Map<String, NivelTecnicaENUM> tecnicas;
    //private Map<String, String> dadosPagamento;
    private String telefone;
    //private List<Producao> listaProducao;

    @Override
    public String toString(){
        return String.format("nome (%s) - cpf (%s) - telefone (%s)", nome, cpf, telefone);
    }
}
