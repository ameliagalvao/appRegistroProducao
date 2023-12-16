package br.edu.infnet.appRegistroProducao.model.service;

import br.edu.infnet.appRegistroProducao.model.clients.IEnderecoClient;
import br.edu.infnet.appRegistroProducao.model.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private IEnderecoClient enderecoClient;

    public Endereco buscarCep(String cep) {
        return enderecoClient.buscarCep(cep);
    }

}
