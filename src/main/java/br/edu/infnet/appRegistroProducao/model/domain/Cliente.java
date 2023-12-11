package br.edu.infnet.appRegistroProducao.model.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;
@Setter
@Getter
@Entity
public class Cliente implements ClienteOuProspecto {
    private String nome;
    private String cnpjOuCpf;
    private String telefone;
    private String email;
    //private List<Pedido> pedidos;

    @Override
    public String toString(){
        return String.format("nome (%s) - cnpjOuCpf (%s) - telefone (%s) - email (%s)", nome, cnpjOuCpf, telefone, email);
    }

    @Override
    public boolean procurarClienteOuProspecto(String cpfOuCnpj) {
        return true;
    }
}
