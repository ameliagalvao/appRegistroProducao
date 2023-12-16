package br.edu.infnet.appRegistroProducao.model.controller;

import br.edu.infnet.appRegistroProducao.model.domain.Producao;
import br.edu.infnet.appRegistroProducao.model.service.ProducaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producao")
public class ProducaoController {

    @Autowired
    private ProducaoService producaoService;

    @GetMapping(value = "/listar")
    public List<Producao> obterLista(){
        return (List<Producao>) producaoService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Producao producao) {
        producaoService.incluir(producao);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        producaoService.excluir(id);
    }
}