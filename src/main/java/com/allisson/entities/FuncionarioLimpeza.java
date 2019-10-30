package com.allisson.entities;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class FuncionarioLimpeza extends Funcionario{

	private static final long serialVersionUID = 1L;
	
	private String supervisorInformacoes;
	private String cargo;
	private String jornadaTrabalho;
	
	public FuncionarioLimpeza() {
		super();
	}

	public FuncionarioLimpeza(Long id, String nome, String endereco, String sexo,
			LocalDate dataNascimento, Double salario, String supervisorInformacoes, String cargo, String jornadaTrabalho) {
		
		super(id, nome, endereco, sexo, dataNascimento, salario);

		this.supervisorInformacoes = supervisorInformacoes;
		this.cargo = cargo;
		this.jornadaTrabalho = jornadaTrabalho;
	}

	

	public String getSupervisorInformacoes() {
		return supervisorInformacoes;
	}

	public void setSupervisorInformacoes(String supervisorInformacoes) {
		this.supervisorInformacoes = supervisorInformacoes;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getJornadaTrabalho() {
		return jornadaTrabalho;
	}

	public void setJornadaTrabalho(String jornadaTrabalho) {
		this.jornadaTrabalho = jornadaTrabalho;
	}

}
