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

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "idPedido")
    private List<Produto> produtos;

    private float valorTotal;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    private boolean isPago;

    private AndamentoEnum andamentoPedido;

    public LocalDateTime calcularPrazo(LocalDateTime dataPedido, LocalDateTime dataEntrega){
        return null;
    }

    public float calcularValorTotal(Map<Produto, Integer> produtos){
        return 0f;
    }
}
