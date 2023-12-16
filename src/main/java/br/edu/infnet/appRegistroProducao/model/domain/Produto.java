package br.edu.infnet.appRegistroProducao.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Embeddable
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduto;
    private String sku;
    private String nome;
    //private List<String> tecnica;
    //private List<String> cores;
    //private Map<String, Float> materiasPrimas;
    private float tempoProducao;
    private float valorMaoDeObra;
    private float custoTotalMateriais;
    private float custoTotalMaoDeObra;
    private float custoTotalProduto;

    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> producoes;

    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos;

    public String toString(){
        return String.format("sku (%s) - nome (%s) - tempoProducao (%.2f) - valorMaoDeObra (%.2f) - custoTotalMateriais (%.2f) - custoTotalMaoDeObra (%.2f) - custoTotalProduto (%.2f)",
                sku, nome, tempoProducao, valorMaoDeObra, custoTotalMateriais, custoTotalMaoDeObra, custoTotalProduto);
    }

    //public float calcularCustoTotalMateriais(Map<String,Float>lista){
    //    return 0f;
    //}

    public float calcularCustoTotalProduto(float custoTotalMateriaisMaterial, float valorMaoDeObra, float tempoProducao){
        return 0f;
    }
}
