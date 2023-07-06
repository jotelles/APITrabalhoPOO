package br.edu.atitus.pooavancado.CadUsuario.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Usuario;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario>{

	boolean existsByNomeAndIdNot(String nome, long id);
	
	@Query(value = "update Usuario set status = not status where id = :id", nativeQuery = true)
	@Modifying
	void alteraStatusById(@Param("id") long id);
	
	Optional<Usuario> findByEmail(String email);

}
