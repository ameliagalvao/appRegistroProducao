package br.edu.infnet.appRegistroProducao.model.domain;

public enum AndamentoEnum {
    NAOINICIADO("Não Iniciado"),
    EM_ANDAMENTO("Em Andamento"),
    SUSPENSO("Suspenso"),
    CANCELADO("Cancelado"),
    CONCLUIDO("Concluído");

    private final String descricao;

    AndamentoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
