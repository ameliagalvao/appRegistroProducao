package br.edu.infnet.appRegistroProducao.model.domain;

import java.time.LocalDateTime;
import java.util.Map;

public class Producao {
    private LocalDateTime dataInicio;
    private LocalDateTime dataEstimadaTermino;
    private AndamentoEnum andamentoProducao;
    private LocalDateTime dataEfetivaTermino;
    private LocalDateTime prazo;
    private Pedido pedido;
    private Map<Artesao, Produto> listaArtesao;

    public LocalDateTime calcularPrazo(LocalDateTime dataInicio, LocalDateTime dataEstimadaTermino){
        return null;
    }

    public float calcularProducaoArtesao(Map<Artesao,Produto> listaArtesao){
        return 0f;
    }
}
