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
    private LocalDateTime dataFinal;
    private AndamentoEnum andamentoProducao;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "PedidoProducao")
    private Pedido pedido;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ArtesaoProducao")
    private Artesao artesao;

    @ElementCollection
    @MapKeyJoinColumn(name = "idProduto")
    @Column(name = "integer_value")
    private Map<Produto, Integer> produtoQuantidade;

    public float calcularProducaoArtesao(Map<Produto,Integer> produtoQuantidade){
        return 0f;
    }
}
