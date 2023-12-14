package br.edu.infnet.appRegistroProducao.model.repositories;

import br.edu.infnet.appRegistroProducao.model.domain.Artesao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtesaoRepository extends CrudRepository<Artesao, Integer> {
}
