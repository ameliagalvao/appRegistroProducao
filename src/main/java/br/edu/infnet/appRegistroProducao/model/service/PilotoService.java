package br.edu.infnet.appRegistroProducao.model.service;

import br.edu.infnet.appRegistroProducao.model.domain.Piloto;
import br.edu.infnet.appRegistroProducao.model.repositories.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PilotoService {
    @Autowired
    private PilotoRepository pilotoRepository;

    public void incluir (Piloto piloto){
        pilotoRepository.save(piloto);
    }
    public Collection<Piloto> obterLista(){
        return (Collection<Piloto>) pilotoRepository.findAll();
    }
}
