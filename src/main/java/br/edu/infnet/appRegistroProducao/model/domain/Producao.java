package br.edu.infnet.appRegistroProducao.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;
@Setter
@Getter
@Entity
public class Producao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataEstimadaTermino;
    @Transient
    private AndamentoEnum andamentoProducao;
    private LocalDateTime dataEfetivaTermino;
    private LocalDateTime prazo;
    @Transient
    private Pedido pedido;
    @Transient
    private Map<Artesao, Produto> listaArtesao;

    public LocalDateTime calcularPrazo(LocalDateTime dataInicio, LocalDateTime dataEstimadaTermino){
        return null;
    }

    public float calcularProducaoArtesao(Map<Artesao,Produto> listaArtesao){
        return 0f;
    }
}
