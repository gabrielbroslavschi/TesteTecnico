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
import br.com.api.rest.repository.EnderecoRepository;

@RestController /*Arquitetura Rest*/
@RequestMapping(value = "/Endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	/* Serviço RESTful*/
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity <Endereco> init(@PathVariable (value = "id") Integer id) {
		
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		return new ResponseEntity<Endereco>(endereco.get(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Endereco>> listarEndereco(){
		
		List<Endereco> list = (List<Endereco>) enderecoRepository.findAll();
		return new ResponseEntity<List<Endereco>>(list, HttpStatus.OK);
	}
	
	
	
	@PostMapping(value="/", produces="application/json")
	public  ResponseEntity<Endereco> cadastrar(@RequestBody Endereco endereco){
		
		Endereco enderecoSalvar = enderecoRepository.save(endereco);
		return new ResponseEntity<Endereco>(enderecoSalvar,HttpStatus.OK);
		
	}
	
	@PutMapping(value="/", produces="application/json")
	public  ResponseEntity<Endereco> atualizar(@RequestBody Endereco endereco){
		
		Endereco enderecoSalvar = enderecoRepository.save(endereco);
		
		return new ResponseEntity<Endereco>(enderecoSalvar,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping(value = "/{id}", produces ="application/text")
	public String delete(@PathVariable("id") Integer id) {
		enderecoRepository.deleteById(id);
		
		return "endereco deletado";
	}
}
