package com.allisson.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.allisson.dao.services.DepartamentoDAO;
import com.allisson.dao.services.FuncionarioLimpezaDAO;
import com.allisson.entities.Departamento;
import com.allisson.entities.Dependente;
import com.allisson.entities.FuncionarioLimpeza;
import com.allisson.entities.jpadao.DepartamentoJPADAO;
import com.allisson.entities.jpadao.FuncionarioLimpezaJPADAO;

public class FuncionarioLimpezaController {


	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	
	public static void buscarFuncionarioLimpezaComDAO() {
		FuncionarioLimpezaDAO cDao = new FuncionarioLimpezaJPADAO();
		List<FuncionarioLimpeza> Funcionarios = cDao.findAll();
		cDao.close();
		System.out.println("\n \t Funcionarios de Limpeza \n");
		for(FuncionarioLimpeza funcionarioLimpeza : Funcionarios) {
			System.out.println("==================================================");
			System.out.println("Id: " + funcionarioLimpeza.getId());
			System.out.println("Id do Departamento: " + funcionarioLimpeza.getDepartamento().getId());
			System.out.println("Nome do Departamento: " + funcionarioLimpeza.getDepartamento().getNome());
			System.out.println("Nome: " + funcionarioLimpeza.getNome());
			System.out.println("Endereco: " + funcionarioLimpeza.getEndereco());
			System.out.println("Sexo: " + funcionarioLimpeza.getSexo());
			System.out.println("Data de Nascimento: " + funcionarioLimpeza.getDataNascimento());
			System.out.println("Salario: " + funcionarioLimpeza.getSalario());
			System.out.println("Informacoes do Supervisor: " + funcionarioLimpeza.getSupervisorInformacoes());
			System.out.println("Cargo: " + funcionarioLimpeza.getCargo());
			System.out.println("Jornada de Trabalho: " + funcionarioLimpeza.getJornadaTrabalho());
		
			System.out.println("\t \nDependentes \n");
			for(Dependente dependente : funcionarioLimpeza.getDependentes()) {
				System.out.println("\t Dependente " + dependente.getNome() + "\n");
				System.out.println("\t \t Id: " + dependente.getId());
				System.out.println("\t \t Sexo: " + dependente.getSexo());
				System.out.println("\t \t Data de Nascimento: " + dependente.getDataNascimento());
				System.out.println("\t \t Grau Parentesco: " + dependente.getGrauParentesco());
			
			}
			System.out.println("==================================================");
		}
		
	}
	
	public static void InserirFuncionarioLimpezaComDAO() {
		
		FuncionarioLimpezaDAO cDao = new FuncionarioLimpezaJPADAO();
		Scanner sc1 = new Scanner(System.in);
		try {
			
			System.out.println("Digite o Id do Departamento:");
			Long departamentoId = sc1.nextLong();
			sc1.nextLine();
			
			if(!DepartamentoController.existDepartamentoComDAO(departamentoId)) {
				throw new Exception("Departamento nao encontrado.");
			}
			
			System.out.println("Digite seu nome :");
			String nome = sc1.nextLine();
			
			System.out.println("Digite seu endereco :");
			String endereco = sc1.nextLine();
			
			System.out.println("Digite seu sexo :");
			String sexo = sc1.nextLine();
			
			System.out.println("Data de nascimento");
			LocalDate dataNascimento =  LocalDate.parse(sc1.nextLine(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
	
			
			System.out.println("Digite o seu salario:");
			Double salario = sc1.nextDouble();
			sc1.nextLine();
	
			System.out.println("Digite informacoes do Funcionario responsavel por sua gerencia:");
			String supervisorInformacoes = sc1.nextLine();
			
			
			System.out.println("Digite seu cargo:");
			String cargo = sc1.nextLine();
			
			System.out.println("Digite sua jornada de trabalho:");
			String jornadaTrabalho = sc1.nextLine();
				
				FuncionarioLimpeza fl = new FuncionarioLimpeza(null, nome, endereco, sexo, dataNascimento, salario, supervisorInformacoes, cargo, jornadaTrabalho);
				DepartamentoDAO dDao = new DepartamentoJPADAO();
				Departamento d1 = dDao.find(departamentoId);
				fl.setDepartamento(d1);
				
				cDao.beginTransaction();
				cDao.save(fl);
				cDao.commit();
			
				
		} catch(Exception e) {
			cDao.rollback();
			System.out.println("\n \n"+"\t \t Erro: Insercao nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");

		} finally {
			cDao.close();
		}
		System.out.println("===========================================");
	}

	public static void AtualizarFuncionarioLimpezaComDAO() {
		
		FuncionarioLimpezaDAO cDao = new FuncionarioLimpezaJPADAO();
		Scanner sc1 = new Scanner(System.in);
		try{
			
		System.out.println("Digite o id do Funcionario de Limpeza a ser atualizado:");
		Long id = sc1.nextLong();
		sc1.nextLine();
			
			System.out.println("Digite o Id do Departamento:");
			Long departamentoId = sc1.nextLong();
			sc1.nextLine();
			
			if(!FuncionarioLimpezaController.existFuncionarioLimpezaComDAO(id)){
				throw new Exception("Funcionario de Limpeza nao encontrado.");
			}
			
			if(!DepartamentoController.existDepartamentoComDAO(departamentoId)) {
				throw new Exception("Departamento nao encontrado.");
			}
			
			System.out.println("Digite seu nome :");
			String nome = sc1.nextLine();
			
			System.out.println("Digite seu endereco :");
			String endereco = sc1.nextLine();
			
			System.out.println("Digite seu sexo :");
			String sexo = sc1.nextLine();
			
			System.out.println("Data de nascimento");
			LocalDate dataNascimento =  LocalDate.parse(sc1.nextLine(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
			
			System.out.println("Digite o seu salario:");
			Double salario = sc1.nextDouble();
			sc1.nextLine();
	
			System.out.println("Digite informacoes do Funcionario responsavel por sua gerencia:");
			String supervisorInformacoes = sc1.nextLine();
			
			
			System.out.println("Digite seu cargo:");
			String cargo = sc1.nextLine();
			
			System.out.println("Digite sua jornada de trabalho:");
			String jornadaTrabalho = sc1.nextLine();
			
			
				
				FuncionarioLimpeza fl = new FuncionarioLimpeza(id, nome, endereco, sexo, dataNascimento, salario, supervisorInformacoes, cargo, jornadaTrabalho);
				DepartamentoDAO dDao = new DepartamentoJPADAO();
				Departamento d1 = dDao.find(departamentoId);
				fl.setDepartamento(d1);
				
				cDao.beginTransaction();
				cDao.save(fl);
				cDao.commit();
				
		
				
		} catch(Exception e) {
			cDao.rollback();
			System.out.println("\n \n"+"\t \t Erro: Atualizacao nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");

		} finally {
			cDao.close();
		}
		System.out.println("===========================================");
	}
	
	public static void deleteFuncionarioLimpezaComDAO() {
		FuncionarioLimpezaDAO cDao = new FuncionarioLimpezaJPADAO();
		Scanner sc1 = new Scanner(System.in);
		try {

			
			System.out.println("Digite o id do Funcionario de Limpeza a ser excluido:");
			Long id = sc1.nextLong();
			
		
				cDao.beginTransaction();
				cDao.deleteById(id);
				cDao.commit();
		
					
			
			System.out.println("===========================================");
			// System.out.println(c);
			cDao.commit();
		} catch(Exception e) {
			cDao.rollback();
			System.out.println("\n \n"+"\t \t Erro: Remocao nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");

		} finally {
			cDao.close();
		}
	}

	public static Boolean existFuncionarioLimpezaComDAO(Long id) {
		FuncionarioLimpezaDAO cDao = new FuncionarioLimpezaJPADAO();
		FuncionarioLimpeza FuncionarioLimpeza = cDao.find(id);
		
		cDao.close();
		if(FuncionarioLimpeza == null)
			return false;
		else 
			return true;
	}
	
	public static void findByIdFLComDAO() {
		Scanner sc1 = new Scanner(System.in);
		
		
		try {
	
			System.out.println("Digite o id do FuncionarioLimpeza:");
			Long id = sc1.nextLong();
			
			FuncionarioLimpezaDAO cDao = new FuncionarioLimpezaJPADAO();
			FuncionarioLimpeza funcionarioLimpeza = cDao.find(id);
			cDao.close();
			
			System.out.println("==================================================");
			System.out.println("Id: " + funcionarioLimpeza.getId());
			System.out.println("Id do Departamento: " + funcionarioLimpeza.getDepartamento().getId());
			System.out.println("Nome do Departamento: " + funcionarioLimpeza.getDepartamento().getNome());
			System.out.println("Nome: " + funcionarioLimpeza.getNome());
			System.out.println("Endereco: " + funcionarioLimpeza.getEndereco());
			System.out.println("Sexo: " + funcionarioLimpeza.getSexo());
			System.out.println("Data de Nascimento: " + funcionarioLimpeza.getDataNascimento());
			System.out.println("Salario: " + funcionarioLimpeza.getSalario());
			System.out.println("Informacoes do Supervisor: " + funcionarioLimpeza.getSupervisorInformacoes());
			System.out.println("Cargo: " + funcionarioLimpeza.getCargo());
			System.out.println("Jornada de Trabalho: " + funcionarioLimpeza.getJornadaTrabalho());
		
			System.out.println("\t \nDependentes \n");
			for(Dependente dependente : funcionarioLimpeza.getDependentes()) {
				System.out.println("\t Dependente " + dependente.getNome() + "\n");
				System.out.println("\t \t Id: " + dependente.getId());
				System.out.println("\t \t Sexo: " + dependente.getSexo());
				System.out.println("\t \t Data de Nascimento: " + dependente.getDataNascimento());
				System.out.println("\t \t Grau Parentesco: " + dependente.getGrauParentesco());
			
			}
			System.out.println("==================================================");
			
		}catch(Exception e) {
			System.out.println("\n \n"+"\t \t Erro: Busca nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");

		}
	}
	

	
}
