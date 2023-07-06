package br.edu.atitus.pooavancado.CadUsuario.controllers;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import br.edu.atitus.pooavancado.CadUsuario.Entities.GenericEntity;
import br.edu.atitus.pooavancado.CadUsuario.services.GenericService;

public abstract class GenericController<TEntidade extends GenericEntity> {
	
	abstract GenericService<TEntidade> getService();
	
	@PostMapping
    public ResponseEntity<Object> save(@RequestBody TEntidade entidade){
        try {
            getService().save(entidade);
            return ResponseEntity.status(HttpStatus.CREATED).body(entidade);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable long id, @RequestBody TEntidade entidade){
        try {
            entidade.setId(id);
            getService().update(entidade, id);
            return ResponseEntity.status(HttpStatus.OK).body(entidade);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

	@GetMapping
    public ResponseEntity<Object> findAll(@RequestParam(required = false) String nome, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<TEntidade> entidadeLista;

        try {
            entidadeLista = getService().findAll(pageable);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(entidadeLista);
    }

	@GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable long id){
        try {
            Optional<TEntidade> entidade = getService().findById(id);

            if(entidade.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe registro com ID " + id);
            else
                return ResponseEntity.status(HttpStatus.OK).body(entidade);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
	}
    


        @DeleteMapping("/{id}")
        public ResponseEntity<Object> delete(@PathVariable long id){
            try {
                getService().deleteById(id);
                return ResponseEntity.status(HttpStatus.OK).body("Registro com ID " + id + " deletado com sucesso.");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        }

}
