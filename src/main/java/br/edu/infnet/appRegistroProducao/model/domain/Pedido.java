package br.edu.infnet.appRegistroProducao.model.domain;

import java.time.LocalDateTime;
import java.util.Map;

public class Pedido {
    private LocalDateTime dataPedido;
    private LocalDateTime dataEntrega;
    private Map<Produto, Integer> produto;
    private LocalDateTime prazo;
    private float valorTotal;
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
