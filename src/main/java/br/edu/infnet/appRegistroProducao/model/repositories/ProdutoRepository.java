package br.edu.infnet.appRegistroProducao.model.repositories;

import br.edu.infnet.appRegistroProducao.model.domain.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}
