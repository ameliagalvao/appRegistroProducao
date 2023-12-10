package br.edu.infnet.appRegistroProducao.model.service;

import br.edu.infnet.appRegistroProducao.model.domain.Piloto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class PilotoService {
    private Map<String, Piloto> mapa = new HashMap<String, Piloto>();

    public void incluir (Piloto piloto){
        mapa.put(piloto.getSku(), piloto);
    }
    public Collection<Piloto> obterLista(){
        return mapa.values();
    }
}