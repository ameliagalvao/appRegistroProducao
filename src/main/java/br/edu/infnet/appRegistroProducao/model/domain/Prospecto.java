package br.edu.infnet.appRegistroProducao.model.domain;

import java.util.List;

public class Prospecto implements ClienteOuProspecto {
    private String nome;
    private String cnpjOuCpf;
    private String telefone;
    private String email;
    private List<Produto> produtos;

    @Override
    public boolean procurarClienteOuProspecto(String cpfOuCnpj) {
        return true;
    }
}
