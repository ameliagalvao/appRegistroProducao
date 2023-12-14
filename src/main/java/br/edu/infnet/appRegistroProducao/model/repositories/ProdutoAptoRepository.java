package br.edu.infnet.appRegistroProducao.model.repositories;

import br.edu.infnet.appRegistroProducao.model.domain.ProdutoAptoProducao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoAptoRepository extends CrudRepository<ProdutoAptoProducao, Integer> {
}
