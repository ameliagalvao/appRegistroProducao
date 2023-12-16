package br.edu.infnet.appRegistroProducao.model.controller;

import br.edu.infnet.appRegistroProducao.model.domain.Cliente;
import br.edu.infnet.appRegistroProducao.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/listar")
    public List<Cliente> obterLista(){
        return (List<Cliente>) clienteService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Cliente cliente) {
        clienteService.incluir(cliente);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        clienteService.excluir(id);
    }
}