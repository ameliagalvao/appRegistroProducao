package br.edu.infnet.appRegistroProducao.model.service;

import br.edu.infnet.appRegistroProducao.model.domain.Cliente;
import br.edu.infnet.appRegistroProducao.model.domain.Endereco;
import br.edu.infnet.appRegistroProducao.model.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoService enderecoService;

    public void incluir (Cliente cliente){
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoService.buscarCep(cep);
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
    public Collection<Cliente> obterLista(){
        return  (Collection<Cliente>) clienteRepository.findAll();
    }
}
