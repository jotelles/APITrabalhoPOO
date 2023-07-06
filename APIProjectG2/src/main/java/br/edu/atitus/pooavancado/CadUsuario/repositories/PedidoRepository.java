package br.edu.atitus.pooavancado.CadUsuario.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Pedido;

@Repository
public interface PedidoRepository extends GenericRepository<Pedido> {

}
