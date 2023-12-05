package br.edu.infnet.appRegistroProducao.model.service;

import br.edu.infnet.appRegistroProducao.model.domain.Cliente;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClienteService {
    private Map<String, Cliente> mapa = new HashMap<String, Cliente>();

    public void incluir (Cliente cliente){
        mapa.put(cliente.getCnpjOuCpf(), cliente);
    }
    public Collection<Cliente> obterLista(){
        return  mapa.values();
    }
}
