package br.edu.infnet.appRegistroProducao.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
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
    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Pedido pedido;
    @ManyToMany
    @JoinTable(
            name = "producao_artesao",
            joinColumns = @JoinColumn(name = "producao_id"),
            inverseJoinColumns = @JoinColumn(name = "artesao_id")
    )
    private List<Artesao> artesaos;

    @ElementCollection
    @CollectionTable(
            name = "producao_artesao_produto",
            joinColumns = @JoinColumn(name = "producao_id")
    )
    @MapKeyJoinColumn(name = "artesao_id")
    @Column(name = "produto_id")
    private Map<Artesao, Produto> artesaoProducao;

    public LocalDateTime calcularPrazo(LocalDateTime dataInicio, LocalDateTime dataEstimadaTermino){
        return null;
    }

    public float calcularProducaoArtesao(Map<Artesao,Produto> listaArtesao){
        return 0f;
    }
}
