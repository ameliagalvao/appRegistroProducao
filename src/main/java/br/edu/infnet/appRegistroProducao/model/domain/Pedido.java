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
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;
    private LocalDateTime dataPedido;
    private LocalDateTime dataEntrega;

    @Transient
    private Map<Produto, Integer> produto;
    private float valorTotal;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ClientePedido")
    private Cliente cliente;

    @OneToMany
    @JoinColumn(name = "PedidoProducao")
    private List<Producao> producoes;

    private boolean isPago;

    private AndamentoEnum andamentoPedido;

    public LocalDateTime calcularPrazo(LocalDateTime dataPedido, LocalDateTime dataEntrega){
        return null;
    }

    public float calcularValorTotal(Map<Produto, Integer> produtos){
        return 0f;
    }
}
