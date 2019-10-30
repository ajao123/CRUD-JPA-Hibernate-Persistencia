package com.allisson.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Trabalho implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer horasSemanais;
	
	@ManyToOne
	@JoinColumn(name="projeto")
	private Projeto projeto;
	
	@ManyToOne
	@JoinColumn(name="pesquisador")
	private Pesquisador pesquisador;
	
	public Trabalho() {
		super();
	}

	public Trabalho(Long id, Integer horasSemanais) {
		super();
		this.id = id;
		this.horasSemanais = horasSemanais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getHorasSemanais() {
		return horasSemanais;
	}

	public void setHorasSemanais(Integer horasSemanais) {
		this.horasSemanais = horasSemanais;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	public Pesquisador getPesquisador() {
		return pesquisador;
	}

	public void setPesquisador(Pesquisador pesquisador) {
		this.pesquisador = pesquisador;
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
		Trabalho other = (Trabalho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
