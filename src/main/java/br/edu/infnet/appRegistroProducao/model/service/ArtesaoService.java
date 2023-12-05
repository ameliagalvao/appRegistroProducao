package br.edu.infnet.appRegistroProducao.model.service;

import br.edu.infnet.appRegistroProducao.model.domain.Artesao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ArtesaoService {
    private Map<String, Artesao> mapa = new HashMap<String, Artesao>();

    public void incluir (Artesao artesao){
        mapa.put(artesao.getCpf(), artesao);
    }
    public Collection<Artesao> obterLista(){
        return  mapa.values();
    }
}
