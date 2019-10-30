package com.allisson.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import javax.persistence.PersistenceException;

import com.allisson.dao.services.DepartamentoDAO;
import com.allisson.dao.services.SecretarioDAO;
import com.allisson.entities.Departamento;
import com.allisson.entities.Dependente;
import com.allisson.entities.Secretario;
import com.allisson.entities.jpadao.DepartamentoJPADAO;
import com.allisson.entities.jpadao.SecretarioJPADAO;

public class SecretarioController {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	
	public static void buscarSecretarioComDAO() {
		SecretarioDAO cDao = new SecretarioJPADAO();
		List<Secretario> Secretarios = cDao.findAll();
		cDao.close();
		System.out.println("\n \t Secretarios \n");
		for(Secretario secretario : Secretarios) {
			System.out.println("===================================================");
			System.out.println("Id: " + secretario.getId());
			System.out.println("Id do Departamento: " + secretario.getDepartamento().getId());
			System.out.println("Nome do Departamento: " + secretario.getDepartamento().getNome());
			System.out.println("Nome: " + secretario.getNome());
			System.out.println("Endereco: " + secretario.getEndereco());
			System.out.println("Sexo: " + secretario.getSexo());
			System.out.println("Data de Nascimento: " + secretario.getDataNascimento());
			System.out.println("Salario: " + secretario.getSalario());
			System.out.println("Grau de Escolaridade: " + secretario.getGrauEscolaridade());
		
			System.out.println("Dependentes \n");
			for(Dependente dependente : secretario.getDependentes()) {
				System.out.println("\t Dependente " + dependente.getNome() + "\n");
				System.out.println("\t \t Id: " + dependente.getId());
				System.out.println("\t \t Sexo: " + dependente.getSexo());
				System.out.println("\t \t Data de Nascimento: " + dependente.getDataNascimento());
				System.out.println("\t \t Grau Parentesco: " + dependente.getGrauParentesco());
			
			}
			System.out.println("===================================================");
		}
		
		
	}

	public static void InserirSecretarioComDAO() {
		
		SecretarioDAO cDao = new SecretarioJPADAO();
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
			
			System.out.println("Digite seu endereço :");
			String endereco = sc1.nextLine();
			
			System.out.println("Digite seu sexo :");
			String sexo = sc1.nextLine();
			
			System.out.println("Digite sua data de nascimento:");
			LocalDate nascimento =  LocalDate.parse(sc1.next(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
			
			System.out.println("Digite o seu salario:");
			Double salario = sc1.nextDouble();
			sc1.nextLine();
			
			System.out.println("Digite seu grau de Escolaridade:");
			String grauEscolaridade = sc1.nextLine();
	
			Secretario s = new Secretario(null, nome, endereco, sexo, nascimento, salario, grauEscolaridade);
			DepartamentoDAO dDao = new DepartamentoJPADAO();
			Departamento d1 = dDao.find(departamentoId);
			s.setDepartamento(d1);
			
			cDao.beginTransaction();
			cDao.save(s);
			cDao.commit();
			
				
			
				
			
		} catch(Exception e) {
			cDao.rollback();
			System.out.println("\n \n"+"\t \t Erro: Insercao nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");		} finally {
			cDao.close();
		}
		System.out.println("===========================================");
	}

	public static void AtualizarSecretarioComDAO() {
		
		SecretarioDAO cDao = new SecretarioJPADAO();
		Scanner sc1 = new Scanner(System.in);
		
		try {
			
			System.out.println("Digite o id do Secretario a ser atualizado:");
			Long id = sc1.nextLong();
			sc1.nextLine();
			
			
			if(!SecretarioController.existSecretarioComDAO(id)) {
				throw new Exception("Secretario nao encontrado.");
			}
			
			System.out.println("Digite o Id do Departamento:");
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
			LocalDate nascimento =  LocalDate.parse(sc1.next(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
			System.out.println("Digite o seu salario:");
			Double salario = sc1.nextDouble();
			sc1.nextLine();
			
			System.out.println("Digite seu grau de Escolaridade:");
			String grauEscolaridade = sc1.nextLine();
	
			


				
				Secretario s = new Secretario(id, nome, endereco, sexo, nascimento, salario, grauEscolaridade);
				DepartamentoDAO dDao = new DepartamentoJPADAO();
				Departamento d1 = dDao.find(departamentoId);
				s.setDepartamento(d1);
				
				cDao.beginTransaction();
				cDao.save(s);
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
	
	public static void deleteSecretarioComDAO() {
		
		SecretarioDAO cDao = new SecretarioJPADAO();
		Scanner sc1 = new Scanner(System.in);
		
		try {
			
			
			System.out.println("Digite o id do Secretario a ser excluido:");
			Long id = sc1.nextLong();

				cDao.beginTransaction();
				cDao.deleteById(id);
				cDao.commit();
		
			
			cDao.close();
			
			System.out.println("===========================================");

			
		} catch(Exception e) {
			cDao.rollback();
			System.out.println("\n \n"+"\t \t Erro: Remocao nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");
		} finally {
			cDao.close();
		}
	}

	public static Boolean existSecretarioComDAO(Long id) {
		SecretarioDAO cDao = new SecretarioJPADAO();
		Secretario Secretario = cDao.find(id);
		
		cDao.close();
		if(Secretario == null)
			return false;
		else 
			return true;
	}

	public static void findByIdSecretarioComDAO() {

		Scanner sc1 = new Scanner(System.in);
		
		try {

			System.out.println("Digite o id do secretario:");
			Long id = sc1.nextLong();
			
			SecretarioDAO cDao = new SecretarioJPADAO();
			Secretario secretario = cDao.find(id);
			cDao.close();
			
			System.out.println("===================================================");
			System.out.println("Id: " + secretario.getId());
			System.out.println("Id do Departamento: " + secretario.getDepartamento().getId());
			System.out.println("Nome do Departamento: " + secretario.getDepartamento().getNome());
			System.out.println("Nome: " + secretario.getNome());
			System.out.println("Endereco: " + secretario.getEndereco());
			System.out.println("Sexo: " + secretario.getSexo());
			System.out.println("Data de Nascimento: " + secretario.getDataNascimento());
			System.out.println("Salario: " + secretario.getSalario());
			System.out.println("Grau de Escolaridade: " + secretario.getGrauEscolaridade());
		
			System.out.println("Dependentes \n");
			for(Dependente dependente : secretario.getDependentes()) {
				System.out.println("\t Dependente " + dependente.getNome() + "\n");
				System.out.println("\t \t Id: " + dependente.getId());
				System.out.println("\t \t Sexo: " + dependente.getSexo());
				System.out.println("\t \t Data de Nascimento: " + dependente.getDataNascimento());
				System.out.println("\t \t Grau Parentesco: " + dependente.getGrauParentesco());
			
			}
			System.out.println("===================================================");
		}catch(Exception e) {
			System.out.println("\n \n"+"\t \t Erro: Busca nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");
		}
			
	
	}
	
}
