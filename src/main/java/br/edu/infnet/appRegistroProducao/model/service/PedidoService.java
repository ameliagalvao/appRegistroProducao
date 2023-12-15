package br.edu.infnet.appRegistroProducao.model.service;

import br.edu.infnet.appRegistroProducao.model.domain.Pedido;
import br.edu.infnet.appRegistroProducao.model.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public void incluir (Pedido pedido){
        pedidoRepository.save(pedido);
    }
    public Collection<Pedido> obterLista(){
        return  (Collection<Pedido>) pedidoRepository.findAll();
    }
}
