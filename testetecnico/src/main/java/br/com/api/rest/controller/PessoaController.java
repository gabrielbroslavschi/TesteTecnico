package br.com.api.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.rest.model.Endereco;
import br.com.api.rest.model.Pessoa;
import br.com.api.rest.repository.EnderecoDaPessoaRepository;
import br.com.api.rest.repository.EnderecoRepository;
import br.com.api.rest.repository.PessoaRepository;

@RestController /* Arquitetura Rest */
@RequestMapping(value = "/Pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private EnderecoDaPessoaRepository enderecoDaPessoaRepository;

	/* Serviço RESTful */
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Pessoa> ini(@PathVariable(value = "id") Integer id) {

		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
	}

	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Pessoa>> listarPessoas() {

		List<Pessoa> list = (List<Pessoa>) pessoaRepository.findAll();
		return new ResponseEntity<List<Pessoa>>(list, HttpStatus.OK);
	}

	@GetMapping(value = "/endereco/{id}", produces = "application/json")
	public ResponseEntity<List<Endereco>> listarEnderecoDaPessoa(@PathVariable(value = "id") Integer id) {

		List<Endereco> list = (List<Endereco>) enderecoDaPessoaRepository.findByEndereco(id);
		return new ResponseEntity<List<Endereco>>(list, HttpStatus.OK);
	}

	@GetMapping(value = "/endereco/principal/{id}", produces = "application/json")
	public ResponseEntity<List<Endereco>> listarEnderecoPrincipalDaPessoa(@PathVariable(value = "id") Integer id) {
		
		List<Endereco> list = (List<Endereco>) enderecoDaPessoaRepository.findByEnderecoPrincipal(id);
		return new ResponseEntity<List<Endereco>>(list, HttpStatus.OK);
	}

	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa) {

		Pessoa pessoaSalvar = pessoaRepository.save(pessoa);
		return new ResponseEntity<Pessoa>(pessoaSalvar, HttpStatus.OK);

	}

	@PutMapping(value = "/", produces = "application/json")
	public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa) {

		Pessoa pessoaSalvar = pessoaRepository.save(pessoa);

		return new ResponseEntity<Pessoa>(pessoaSalvar, HttpStatus.OK);

	}

	@DeleteMapping(value = "/{id}", produces = "application/text")
	public String delete(@PathVariable("id") Integer id) {
		pessoaRepository.deleteById(id);

		return "Usuário deletado";
	}
}
