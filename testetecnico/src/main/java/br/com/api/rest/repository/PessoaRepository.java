package br.com.api.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.rest.model.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Integer>{
	
}
