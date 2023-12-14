package br.edu.infnet.appRegistroProducao.model.repositories;

import br.edu.infnet.appRegistroProducao.model.domain.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}
