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
    private LocalDateTime dataFinal;
    private AndamentoEnum andamentoProducao;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "idArtesao")
    private Artesao artesao;

    @ManyToMany
    @JoinTable(name = "producao_produto",
            joinColumns = @JoinColumn(name = "idProducao"),
            inverseJoinColumns = @JoinColumn(name = "idProduto"))
    private List<Produto> produtos;

    public float calcularProducaoArtesao(Map<Produto,Integer> produtoQuantidade){
        return 0f;
    }
}
