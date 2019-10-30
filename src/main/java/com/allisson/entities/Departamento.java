package com.allisson.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;


@Entity
public class Departamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER, orphanRemoval=true)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Pesquisador> pesquisadores = new ArrayList<>();
	
	@OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER, orphanRemoval=true)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Secretario> secretarios = new ArrayList<>();
	
	@OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER, orphanRemoval=true)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<FuncionarioLimpeza> funcionariosLimpeza = new ArrayList<>();
	
	@OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER, orphanRemoval=true)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Projeto> projetos = new ArrayList<>();
	
	public Departamento() {
		super();
	}
	
	public Departamento(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<Pesquisador> getPesquisadores() {
		return pesquisadores;
	}
	
	
	public void setPesquisadores(List<Pesquisador> pesquisadores) {
		this.pesquisadores = pesquisadores;
	}
	

	public List<Secretario> getSecretarios() {
		return secretarios;
	}

	public void setSecretarios(List<Secretario> secretarios) {
		this.secretarios = secretarios;
	}

	public List<FuncionarioLimpeza> getFuncionariosLimpeza() {
		return funcionariosLimpeza;
	}

	public void setFuncionariosLimpeza(List<FuncionarioLimpeza> funcionariosLimpeza) {
		this.funcionariosLimpeza = funcionariosLimpeza;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	
}
