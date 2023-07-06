package br.edu.atitus.pooavancado.CadUsuario.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Produto;

@Repository
public interface ProdutoRepository extends GenericRepository<Produto>{

	boolean existsByNomeAndIdNot(String nome, Long id);
}
