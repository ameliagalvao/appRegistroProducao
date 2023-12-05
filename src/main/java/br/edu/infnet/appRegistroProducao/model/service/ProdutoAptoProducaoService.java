package br.edu.infnet.appRegistroProducao.model.service;

import br.edu.infnet.appRegistroProducao.model.domain.ProdutoAptoProducao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class ProdutoAptoProducaoService {
    private Map<String, ProdutoAptoProducao> mapa = new HashMap<String, ProdutoAptoProducao>();

    public void incluir (ProdutoAptoProducao produto){
        mapa.put(produto.getSku(), produto);
    }
    public Collection<ProdutoAptoProducao> obterLista(){
        return  mapa.values();
    }
}
