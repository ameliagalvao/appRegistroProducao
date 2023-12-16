package br.edu.infnet.appRegistroProducao.model.domain;

public enum NivelTecnicaENUM {
    INICIANTE("Iniciante"),
    INTERMEDIARIO("Intermediário"),
    AVANCADO("Avançado");

    private final String descricao;

    NivelTecnicaENUM(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}