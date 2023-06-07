package com.cadastro.cadastroPessoa.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pessoa {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	@Column(nullable = false)
	    private String nome;
	 	@Column(nullable = false)
	    private String cpf;
	 	@Column(nullable = false)
	    private String dataNascimento;

	    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	    private List<Contato> contatos;

	    // Construtores, getters e setters

	    public Pessoa() {
	    	
	    }

	    public Pessoa(String nome, String cpf, String dataNascimento, List<Contato> contatos) {
	        this.nome = nome;
	        this.cpf = cpf;
	        this.dataNascimento = dataNascimento;
	        this.contatos = contatos;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(String dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

		public List<Contato> getContatos() {
			return contatos;
		}

		public void setContatos(List<Contato> contatos) {
			this.contatos = contatos;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

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
