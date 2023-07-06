package br.edu.atitus.pooavancado.CadUsuario.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.atitus.pooavancado.CadUsuario.Entities.GenericEntity;
import br.edu.atitus.pooavancado.CadUsuario.repositories.GenericRepository;

public interface GenericService<TEntidade extends GenericEntity> {

	GenericRepository<TEntidade> getRepository();
	
	default TEntidade save(TEntidade entidade) throws Exception {
		return this.getRepository().save(entidade);
	}

	default Optional<TEntidade> findById(long id) throws Exception{
		if (!getRepository().existsById(id))
			throw new Exception("Não existe registro com este Id");
		return getRepository().findById(id);
	}
	
	default Page<TEntidade> findAll(Pageable pageable) throws Exception {
		return this.getRepository().findAll(pageable);
	}
	
	default TEntidade update(TEntidade entidade, Long id) throws Exception {
		if(!this.getRepository().existsById(id))
			throw new Exception("Não existe registro com ID " + id);
		return this.getRepository().save(entidade);
	}

	default void deleteById(Long id) throws Exception {
		if(!this.getRepository().existsById(id))
			throw new Exception("Não existe registro com ID " + id);
		this.getRepository().deleteById(id);
	}
}
