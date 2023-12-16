package br.edu.infnet.appRegistroProducao.model.controller;

import br.edu.infnet.appRegistroProducao.model.domain.Artesao;
import br.edu.infnet.appRegistroProducao.model.service.ArtesaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artesao")
public class ArtesaoController {

    @Autowired
    private ArtesaoService artesaoService;

    @GetMapping(value = "/listar")
    public List<Artesao> obterLista(){
        return (List<Artesao>) artesaoService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Artesao artesao) {
        artesaoService.incluir(artesao);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        artesaoService.excluir(id);
    }
}