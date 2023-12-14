package br.edu.infnet.appRegistroProducao.model.service;

import br.edu.infnet.appRegistroProducao.model.domain.Piloto;
import br.edu.infnet.appRegistroProducao.model.domain.ProdutoAptoProducao;
import br.edu.infnet.appRegistroProducao.model.repositories.ProdutoAptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class ProdutoAptoProducaoService {
    @Autowired
    private ProdutoAptoRepository produtoAptoRepository;

    public void incluir (ProdutoAptoProducao produtoAptoProducao){
        produtoAptoRepository.save(produtoAptoProducao);
    }
    public Collection<ProdutoAptoProducao> obterLista(){
        return (Collection<ProdutoAptoProducao>) produtoAptoRepository.findAll();
    }
}