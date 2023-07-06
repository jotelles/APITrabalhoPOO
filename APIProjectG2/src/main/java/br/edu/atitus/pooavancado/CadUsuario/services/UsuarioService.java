package br.edu.atitus.pooavancado.CadUsuario.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Usuario;
import br.edu.atitus.pooavancado.CadUsuario.repositories.UsuarioRepository;

public interface UsuarioService extends GenericService<Usuario>, UserDetailsService {
	
	void alteraStatus(long id) throws Exception;

}
