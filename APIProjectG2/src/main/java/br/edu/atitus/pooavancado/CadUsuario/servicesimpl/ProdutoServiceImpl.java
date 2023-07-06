package br.edu.atitus.pooavancado.CadUsuario.servicesimpl;

import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Produto;
import br.edu.atitus.pooavancado.CadUsuario.Entities.Usuario;
import br.edu.atitus.pooavancado.CadUsuario.repositories.GenericRepository;
import br.edu.atitus.pooavancado.CadUsuario.repositories.ProdutoRepository;
import br.edu.atitus.pooavancado.CadUsuario.services.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{

	final ProdutoRepository produtoRepository;
	
	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@Override
	public ProdutoRepository getRepository() {
		return produtoRepository;
	}
	
	@Override
	public Produto save(Produto produto) throws Exception {
		if(this.getRepository().existsByNomeAndIdNot(produto.getNome(), produto.getId()))
			throw new Exception("Já existe registro com este nome.");
		
		return this.produtoRepository.save(produto);
	}
}
