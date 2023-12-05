package br.edu.infnet.appRegistroProducao.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ProdutoAptoProducao extends Produto {

    //private List<String> variacoes;
    private float lucro;
    private float precoFinal;

    public String toString(){
        return  String.format(" %s - lucro (%f) - preco final (%f)",
                super.toString(), lucro, precoFinal);
    }

    public float calcularPrecoFinal(float custoTotal, float lucro){
        return 0f;
    }
}
