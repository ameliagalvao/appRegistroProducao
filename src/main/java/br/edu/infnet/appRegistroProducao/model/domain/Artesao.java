package br.edu.infnet.appRegistroProducao.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
@Setter
@Getter
public class Artesao {
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
