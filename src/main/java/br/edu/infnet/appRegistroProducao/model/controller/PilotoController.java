package br.edu.infnet.appRegistroProducao.model.controller;

import br.edu.infnet.appRegistroProducao.model.domain.Piloto;
import br.edu.infnet.appRegistroProducao.model.service.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/piloto")
public class PilotoController {

    @Autowired
    private PilotoService pilotoService;

    @GetMapping(value = "/listar")
    public List<Piloto> obterLista(){
        return (List<Piloto>) pilotoService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Piloto piloto) {
        pilotoService.incluir(piloto);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        pilotoService.excluir(id);
    }
}