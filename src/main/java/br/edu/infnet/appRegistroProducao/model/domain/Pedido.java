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
    private LocalDateTime prazo;
    private float valorTotal;
    @ManyToOne
    @JoinColumn(name = "idPedidoCliente")
    private Cliente cliente;
    @OneToMany(mappedBy = "pedido")
    private List<Producao> producoes;
    private boolean isPago;
    @Transient
    private AndamentoEnum andamentoPedido;

    public LocalDateTime calcularPrazo(LocalDateTime dataPedido, LocalDateTime dataEntrega){
        return null;
    }

    public float calcularValorTotal(Map<Produto, Integer> produtos){
        return 0f;
    }
}
