package br.edu.atitus.pooavancado.CadUsuario.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Produto;
import br.edu.atitus.pooavancado.CadUsuario.repositories.GenericRepository;
import br.edu.atitus.pooavancado.CadUsuario.repositories.ProdutoRepository;

public interface ProdutoService extends GenericService<Produto> {
	
}
