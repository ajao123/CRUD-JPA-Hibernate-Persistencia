package com.allisson.entities;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Secretario extends Funcionario{

	private static final long serialVersionUID = 1L;
	
	private String grauEscolaridade;
	
	
	public Secretario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Secretario(Long id, String nome, String endereco, String sexo,
			LocalDate dataNascimento, Double salario, String grauEscolaridade) {
		super(id, nome, endereco, sexo, dataNascimento, salario);
		this.grauEscolaridade = grauEscolaridade;
	}
	
	public String getGrauEscolaridade() {
		return grauEscolaridade;
	}

	public void setGrauEscolaridade(String grauEscolaridade) {
		this.grauEscolaridade = grauEscolaridade;
	}

}
