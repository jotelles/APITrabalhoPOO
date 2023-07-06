package br.edu.atitus.pooavancado.CadUsuario.servicesimpl;

import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Pedido;
import br.edu.atitus.pooavancado.CadUsuario.repositories.GenericRepository;
import br.edu.atitus.pooavancado.CadUsuario.repositories.PedidoRepository;
import br.edu.atitus.pooavancado.CadUsuario.services.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	final PedidoRepository pedidoRepository;
	public PedidoServiceImpl(PedidoRepository pedidoRepository) {
//		super();
		this.pedidoRepository = pedidoRepository;
	}
	
	@Override
	public PedidoRepository getRepository() {
		return pedidoRepository;
	}
	
}
