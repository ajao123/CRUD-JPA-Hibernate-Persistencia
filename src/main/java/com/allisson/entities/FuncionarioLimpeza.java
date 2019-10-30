package com.allisson.entities;

import java.io.Serializable;
import java.time.LocalDate;
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
public class FuncionarioLimpeza implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="departamento")
	private Departamento departamento;
	
	@OneToMany(mappedBy = "funcionarioLimpeza", fetch = FetchType.EAGER, orphanRemoval=true)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Dependente> dependentes = new ArrayList<>();
	
	
	private String nome;
	private String endereco;
	private String sexo;
	private LocalDate dataNascimento;
	private Double salario;
	private String supervisorInformacoes;
	private String cargo;
	private String jornadaTrabalho;
	
	public FuncionarioLimpeza() {
		super();
	}

	public FuncionarioLimpeza(Long id, String nome, String endereco, String sexo,
			LocalDate dataNascimento, Double salario, String supervisorInformacoes, String cargo, String jornadaTrabalho) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.supervisorInformacoes = supervisorInformacoes;
		this.cargo = cargo;
		this.jornadaTrabalho = jornadaTrabalho;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
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
	
	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
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
		FuncionarioLimpeza other = (FuncionarioLimpeza) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
