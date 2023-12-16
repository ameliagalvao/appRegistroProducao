package br.edu.infnet.appRegistroProducao.model.controller;

import br.edu.infnet.appRegistroProducao.model.domain.ProdutoAptoProducao;
import br.edu.infnet.appRegistroProducao.model.service.ProdutoAptoProducaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtoapto")
public class ProdutoAptoController {

    @Autowired
    private ProdutoAptoProducaoService produtoAptoProducaoService;

    @GetMapping(value = "/listar")
    public List<ProdutoAptoProducao> obterLista(){
        return (List<ProdutoAptoProducao>) produtoAptoProducaoService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody ProdutoAptoProducao produtoAptoProducao) {
        produtoAptoProducaoService.incluir(produtoAptoProducao);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        produtoAptoProducaoService.excluir(id);
    }
}