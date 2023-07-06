package br.edu.atitus.pooavancado.CadUsuario.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Pedido;
import br.edu.atitus.pooavancado.CadUsuario.services.GenericService;
import br.edu.atitus.pooavancado.CadUsuario.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(originPatterns = "*")
public class PedidoController extends GenericController<Pedido>{
	
	final PedidoService pedidoService;
	
	public PedidoController(PedidoService pedidoService) {
//		super();
		this.pedidoService = pedidoService;
	}

	@Override
	GenericService<Pedido> getService() {
		return pedidoService;
	}
}
