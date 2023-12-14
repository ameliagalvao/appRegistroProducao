package br.edu.infnet.appRegistroProducao.model.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Piloto extends Produto{
    private boolean isAprovado;

    public String toString(){
        return String.format("%s - Status de aprovação (%b)",
                super.toString(), isAprovado);
    }

}
