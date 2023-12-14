package br.edu.infnet.appRegistroProducao.model.repositories;

import br.edu.infnet.appRegistroProducao.model.domain.Piloto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotoRepository extends CrudRepository<Piloto, Integer> {
}
