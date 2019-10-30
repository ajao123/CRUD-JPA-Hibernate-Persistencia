package com.allisson.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.allisson.dao.services.DepartamentoDAO;
import com.allisson.dao.services.PesquisadorDAO;
import com.allisson.entities.Departamento;
import com.allisson.entities.Dependente;
import com.allisson.entities.Pesquisador;
import com.allisson.entities.Trabalho;
import com.allisson.entities.jpadao.DepartamentoJPADAO;
import com.allisson.entities.jpadao.PesquisadorJPADAO;

public class PesquisadorController {

	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	
	public static void buscarPesquisadorComDAO() {
		PesquisadorDAO cDao = new PesquisadorJPADAO();
		List<Pesquisador> Pesquisadores = cDao.findAll();
		cDao.close();
		System.out.println("\n \t Pesquisadores \n");
		for(Pesquisador pesquisador : Pesquisadores) {
			System.out.println("===================================================");
			System.out.println("Id: " + pesquisador.getId());
			System.out.println("Id do Departamento: " + pesquisador.getDepartamento().getId());
			System.out.println("Nome do Departamento: " + pesquisador.getDepartamento().getNome());
			System.out.println("Nome:" + pesquisador.getNome());
			System.out.println("Endereco: " + pesquisador.getEndereco());
			System.out.println("Sexo: " + pesquisador.getSexo());
			System.out.println("Data de Nascimento: " + pesquisador.getDataNascimento());
			System.out.println("Salario: " + pesquisador.getSalario());
			System.out.println("Area de Atuacao: " + pesquisador.getAreaAtuacao()+"\n");
			
			System.out.println("Dependentes \n");
			for(Dependente dependente : pesquisador.getDependentes()) {
				System.out.println("\t Dependente " + dependente.getNome() + "\n");
				System.out.println("\t \t Id: " + dependente.getId());
				System.out.println("\t \t Sexo: " + dependente.getSexo());
				System.out.println("\t \t Data de Nascimento: " + dependente.getDataNascimento());
				System.out.println("\t \t Grau Parentesco: " + dependente.getGrauParentesco());
			
			}
			System.out.println("Trabalhos \n");
			for(Trabalho trabalho : pesquisador.getTrabalhos()) {
				System.out.println("\t Id: " + trabalho.getId());
				System.out.println("\t Projeto: "+ trabalho.getProjeto().getNome());
				System.out.println("\t Id do Projeto: "+ trabalho.getProjeto().getId());
				System.out.println("\t Departamento Responsavel: "+ trabalho.getProjeto().getDepartamento().getNome());
				System.out.println("\t Id do Departamento Responsavel: "+ trabalho.getProjeto().getDepartamento().getId());
				System.out.println("\t Tempo de Projeto: "+ trabalho.getProjeto().getPeriodoTempo());
				System.out.println("\t Horas Semanais: " + trabalho.getHorasSemanais());
				
				System.out.println("\n");
			}
			System.out.println("===================================================");
		}
		
	}
	
	public static void InserirPesquisadorComDAO() {
		PesquisadorDAO cDao = new PesquisadorJPADAO();
		Scanner sc1 = new Scanner(System.in);
		
		try {
			System.out.println("Digite o id do Departamento :");
			Long departamentoId = sc1.nextLong();
			sc1.nextLine();
			
			if(!DepartamentoController.existDepartamentoComDAO(departamentoId)) {
				throw new Exception("Departamento nao encontrado.");
			}
			
			System.out.println("Digite seu nome :");
			String nome = sc1.nextLine();
			
			System.out.println("Digite seu endereço :");
			String endereco = sc1.nextLine();
	
			
			System.out.println("Digite seu sexo :");
			String sexo = sc1.nextLine();
			
			
			System.out.println("Digite sua data de nascimento:");
			LocalDate nascimento =  LocalDate.parse(sc1.nextLine(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
			
			System.out.println("Digite o seu salario:");
			Double salario = sc1.nextDouble();
			sc1.nextLine();
			
			System.out.println("Digite a Area de atuacao:");
			String atuacao = sc1.nextLine();

				DepartamentoDAO dDao = new DepartamentoJPADAO();
				Departamento d1 = dDao.find(departamentoId);
				Pesquisador p = new Pesquisador(null, nome, endereco, sexo, nascimento, salario, atuacao);
				p.setDepartamento(d1);
				
				cDao.beginTransaction();
				cDao.save(p);
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

	public static void AtualizarPesquisadorComDAO() {
		PesquisadorDAO cDao = new PesquisadorJPADAO();
		Scanner sc1 = new Scanner(System.in);
		
		
		try {
			
			System.out.println("Digite o id do Pesquisador a ser atualizado:");
			Long id = sc1.nextLong();
			sc1.nextLine();
			
			if(!PesquisadorController.existPesquisadorComDAO(id)) {
				throw new Exception("Pesquisador nao encontrado.");
			}
			
			System.out.println("Digite o id do Departamento :");
			Long departamentoId = sc1.nextLong();
			sc1.nextLine();
			
			if(!DepartamentoController.existDepartamentoComDAO(departamentoId)) {
				throw new Exception("Departamento nao encontrado.");
			}
			
			System.out.println("Digite seu nome :");
			String nome = sc1.nextLine();
			
			System.out.println("Digite seu endereço :");
			String endereco = sc1.nextLine();
	
			
			System.out.println("Digite seu sexo :");
			String sexo = sc1.nextLine();
			
			
			System.out.println("Digite sua data de nascimento:");
			LocalDate nascimento =  LocalDate.parse(sc1.nextLine(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
			
			System.out.println("Digite o seu salario:");
			Double salario = sc1.nextDouble();
			sc1.nextLine();
			
			System.out.println("Digite a Area de atuacao:");
			String atuacao = sc1.nextLine();
		
			
				DepartamentoDAO dDao = new DepartamentoJPADAO();
				Departamento d1 = dDao.find(departamentoId);
				Pesquisador p = new Pesquisador(id, nome, endereco, sexo, nascimento, salario, atuacao);
				p.setDepartamento(d1);
				
				cDao.beginTransaction();
				cDao.save(p);
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
	
	public static void deletePesquisadorComDAO() {
		PesquisadorDAO cDao = new PesquisadorJPADAO();
		Scanner sc1 = new Scanner(System.in);
		
		try {
			

			System.out.println("Digite o id do Pesquisador a ser excluido:");
			Long id = sc1.nextLong();
			
			cDao.beginTransaction();
			cDao.deleteById(id);
			cDao.commit();
						
			System.out.println("===========================================");
	
			
		} catch(Exception e) {
			cDao.rollback();
			System.out.println("\n \n"+"\t \t Erro: Remocao nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");

		} finally {
			cDao.close();
		}
	}

	public static Boolean existPesquisadorComDAO(Long id) {
		PesquisadorDAO cDao = new PesquisadorJPADAO();
		Pesquisador Pesquisador = cDao.find(id);
		
		cDao.close();
		if(Pesquisador == null)
			return false;
		else 
			return true;
	}

	public static void findByIdPesquisadorComDAO() {
		
		Scanner sc1 = new Scanner(System.in);
		
		try {
			
			System.out.println("Digite o id do Pesquisador:");
			Long id = sc1.nextLong();
			
			PesquisadorDAO cDao = new PesquisadorJPADAO();
			Pesquisador pesquisador = cDao.find(id);
			cDao.close();
			
			System.out.println("===================================================");
			System.out.println("Id: " + pesquisador.getId());
			System.out.println("Id do Departamento: " + pesquisador.getDepartamento().getId());
			System.out.println("Nome do Departamento: " + pesquisador.getDepartamento().getNome());
			System.out.println("Nome:" + pesquisador.getNome());
			System.out.println("Endereco: " + pesquisador.getEndereco());
			System.out.println("Sexo: " + pesquisador.getSexo());
			System.out.println("Data de Nascimento: " + pesquisador.getDataNascimento());
			System.out.println("Salario: " + pesquisador.getSalario());
			System.out.println("Area de Atuacao: " + pesquisador.getAreaAtuacao()+"\n");
			
			System.out.println("Dependentes \n");
			for(Dependente dependente : pesquisador.getDependentes()) {
				System.out.println("\t Dependente " + dependente.getNome() + "\n");
				System.out.println("\t \t Id: " + dependente.getId());
				System.out.println("\t \t Sexo: " + dependente.getSexo());
				System.out.println("\t \t Data de Nascimento: " + dependente.getDataNascimento());
				System.out.println("\t \t Grau Parentesco: " + dependente.getGrauParentesco());
			
			}
			System.out.println("Trabalhos \n");
			for(Trabalho trabalho : pesquisador.getTrabalhos()) {
				System.out.println("\t Id: " + trabalho.getId());
				System.out.println("\t Projeto: "+ trabalho.getProjeto().getNome());
				System.out.println("\t Id do Projeto: "+ trabalho.getProjeto().getId());
				System.out.println("\t Departamento Responsavel: "+ trabalho.getProjeto().getDepartamento().getNome());
				System.out.println("\t Id do Departamento Responsavel: "+ trabalho.getProjeto().getDepartamento().getId());
				System.out.println("\t Tempo de Projeto: "+ trabalho.getProjeto().getPeriodoTempo());
				System.out.println("\t Horas Semanais: " + trabalho.getHorasSemanais());
				
				System.out.println("\n");
			}
			System.out.println("===================================================");
		}catch(Exception e) {
			System.out.println("\n \n"+"\t \t Erro: Busca nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");

		}
		
	}
	
	public static void findByIdPesquisadorComDAO(Long id) {
		
		try {
			PesquisadorDAO cDao = new PesquisadorJPADAO();
			Pesquisador pesquisador = cDao.find(id);
			cDao.close();
			System.out.println("===================================================");
			System.out.println("Id: " + pesquisador.getId());
			System.out.println("Id do Departamento: " + pesquisador.getDepartamento().getId());
			System.out.println("Nome do Departamento: " + pesquisador.getDepartamento().getNome());
			System.out.println("Nome:" + pesquisador.getNome());
			System.out.println("Endereco: " + pesquisador.getEndereco());
			System.out.println("Sexo: " + pesquisador.getSexo());
			System.out.println("Data de Nascimento: " + pesquisador.getDataNascimento());
			System.out.println("Salario: " + pesquisador.getSalario());
			System.out.println("Area de Atuacao: " + pesquisador.getAreaAtuacao()+"\n");
			
			System.out.println("Dependentes \n");
			for(Dependente dependente : pesquisador.getDependentes()) {
				System.out.println("\t Dependente " + dependente.getNome() + "\n");
				System.out.println("\t \t Id: " + dependente.getId());
				System.out.println("\t \t Sexo: " + dependente.getSexo());
				System.out.println("\t \t Data de Nascimento: " + dependente.getDataNascimento());
				System.out.println("\t \t Grau Parentesco: " + dependente.getGrauParentesco());
			
			}
			System.out.println("Trabalhos \n");
			for(Trabalho trabalho : pesquisador.getTrabalhos()) {
				System.out.println("\t Id: " + trabalho.getId());
				System.out.println("\t Projeto: "+ trabalho.getProjeto().getNome());
				System.out.println("\t Id do Projeto: "+ trabalho.getProjeto().getId());
				System.out.println("\t Departamento Responsavel: "+ trabalho.getProjeto().getDepartamento().getNome());
				System.out.println("\t Id do Departamento Responsavel: "+ trabalho.getProjeto().getDepartamento().getId());
				System.out.println("\t Tempo de Projeto: "+ trabalho.getProjeto().getPeriodoTempo());
				System.out.println("\t Horas Semanais: " + trabalho.getHorasSemanais());
				
				System.out.println("\n");
			}
			System.out.println("===================================================");
		}catch(Exception e) {
			System.out.println("\n \n"+"\t \t Erro: Busca nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");
		}
		
	}
	
}
