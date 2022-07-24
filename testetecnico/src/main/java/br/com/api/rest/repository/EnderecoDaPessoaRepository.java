package br.com.api.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.api.rest.model.Pessoa;

public interface EnderecoDaPessoaRepository extends PagingAndSortingRepository<Pessoa, Integer>{
	
	@Query(value = "SELECT * FROM ENDERECO f WHERE f.PESSOA_ID= :pessoa",
			nativeQuery = true)
	List findByEndereco(Integer pessoa);
	
	
	@Query(value = "SELECT * FROM ENDERECO f WHERE f.PESSOA_ID= :pessoa AND f.PRINCIPAL = 1",
			nativeQuery = true)
	List findByEnderecoPrincipal(Integer pessoa);
	
}
