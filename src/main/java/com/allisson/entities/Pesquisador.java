package com.allisson.entities;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;

@Entity
public class Pesquisador extends Funcionario{

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "pesquisador", fetch = FetchType.EAGER, orphanRemoval=true)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Trabalho> trabalhos;
	
	
	private String areaAtuacao;
	
	public Pesquisador() {
		super();
	}
	
	public Pesquisador(Long id, String nome, String endereco, String sexo,
			LocalDate dataNascimento, Double salario, String areaAtuacao) {
		
		super(id, nome, endereco, sexo, dataNascimento, salario);
		this.areaAtuacao = areaAtuacao;
		trabalhos = new ArrayList<>();
	}


	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public List<Trabalho> getTrabalhos() {
		return trabalhos;
	}

	public void setTrabalhos(List<Trabalho> trabalhos) {
		this.trabalhos = trabalhos;
	}
	
}
