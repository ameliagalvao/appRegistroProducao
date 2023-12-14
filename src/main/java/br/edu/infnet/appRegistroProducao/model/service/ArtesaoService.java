package br.edu.infnet.appRegistroProducao.model.service;

import br.edu.infnet.appRegistroProducao.model.domain.Artesao;
import br.edu.infnet.appRegistroProducao.model.repositories.ArtesaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ArtesaoService {

    @Autowired
    private ArtesaoRepository artesaoRepository;

    public void incluir (Artesao artesao){
        artesaoRepository.save(artesao);
    }
    public Collection<Artesao> obterLista(){
        return  (Collection<Artesao>) artesaoRepository.findAll();
    }
}
