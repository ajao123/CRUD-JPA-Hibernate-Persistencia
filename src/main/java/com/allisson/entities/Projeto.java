package com.allisson.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;

@Entity
public class Projeto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="departamento")
	private Departamento departamento;
	
	@OneToMany(mappedBy = "projeto", fetch = FetchType.EAGER, orphanRemoval=true)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Trabalho> trabalhos = new ArrayList<>();
	
	private String nome;
	private String periodoTempo;
	
	public Projeto() {
		super();
	}
	
	
	public Projeto(Long id, String nome, String periodoTempo) {
		super();
		this.id = id;
		this.nome = nome;
		this.periodoTempo = periodoTempo;
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
	
	public String getPeriodoTempo() {
		return periodoTempo;
	}
	
	public void setPeriodoTempo(String periodoTempo) {
		this.periodoTempo = periodoTempo;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Trabalho> getTrabalhos() {
		return trabalhos;
	}


	public void setTrabalhos(List<Trabalho> trabalhos) {
		this.trabalhos = trabalhos;
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
		Projeto other = (Projeto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
