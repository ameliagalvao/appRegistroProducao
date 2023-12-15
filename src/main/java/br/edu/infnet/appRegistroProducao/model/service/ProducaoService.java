package br.edu.infnet.appRegistroProducao.model.service;

import br.edu.infnet.appRegistroProducao.model.domain.Producao;
import br.edu.infnet.appRegistroProducao.model.repositories.ProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class ProducaoService {
    @Autowired
    private ProducaoRepository producaoRepository;

    public void incluir (Producao producao){
        producaoRepository.save(producao);
    }
    public Collection<Producao> obterLista(){
        return  (Collection<Producao>) producaoRepository.findAll();
    }
}
