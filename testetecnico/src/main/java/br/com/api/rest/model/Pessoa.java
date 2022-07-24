package br.com.api.rest.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class Pessoa implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id //Informo que o "id" é o ID da tabela
	@GeneratedValue(strategy = GenerationType.AUTO) //O ID se auto gera
	private Integer id;	//Crio o atributo ID para uma pessoa
	
	//Crio os demais atributos
	private String nome;
	private String dataNascimento;
	
	
	
	//Realizo a inserção dos getters and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	//Realizo a inserção dos HashCode() and Equals()
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
