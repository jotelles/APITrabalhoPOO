package br.edu.atitus.pooavancado.CadUsuario.servicesimpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Produto;
import br.edu.atitus.pooavancado.CadUsuario.Entities.Usuario;
import br.edu.atitus.pooavancado.CadUsuario.repositories.GenericRepository;
import br.edu.atitus.pooavancado.CadUsuario.repositories.UsuarioRepository;
import br.edu.atitus.pooavancado.CadUsuario.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	final UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public UsuarioRepository getRepository() {
		return usuarioRepository;
	}

	@Override
	public void alteraStatus(long id) throws Exception {
		if (!usuarioRepository.existsById(id))
			throw new Exception("Não existe registro com este Id");
		usuarioRepository.alteraStatusById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = this.usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o e-mail: " + email));
		return usuario;
	}
	
	@Override
	public Usuario save(Usuario usuario) throws Exception {
		if(this.getRepository().existsByNomeAndIdNot(usuario.getNome(), usuario.getId()))
			throw new Exception("Já existe registro com este nome.");
		
		return this.usuarioRepository.save(usuario);
	}
	

}
