package com.allisson.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.allisson.dao.services.DependenteDAO;
import com.allisson.dao.services.FuncionarioLimpezaDAO;
import com.allisson.dao.services.PesquisadorDAO;
import com.allisson.dao.services.SecretarioDAO;
import com.allisson.entities.Dependente;
import com.allisson.entities.FuncionarioLimpeza;
import com.allisson.entities.Pesquisador;
import com.allisson.entities.Secretario;
import com.allisson.entities.jpadao.DependenteJPADAO;
import com.allisson.entities.jpadao.FuncionarioLimpezaJPADAO;
import com.allisson.entities.jpadao.PesquisadorJPADAO;
import com.allisson.entities.jpadao.SecretarioJPADAO;

public class DependenteController {

	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	
	public static void buscarDependenteComDAO() {
		DependenteDAO cDao = new DependenteJPADAO();
		List<Dependente> Dependentes = cDao.findAll();
		cDao.close();
		System.out.println("\n \t Dependentes \n");
		for(Dependente dependente : Dependentes) {
			System.out.println("==================================================");
			
			System.out.println("Id Funcionario: " + dependente.getFuncionario().getId());
			System.out.println("Nome Funcionario: " + dependente.getFuncionario().getNome());
			System.out.println("Id: " + dependente.getId());
			System.out.println("Nome: " + dependente.getNome());
			System.out.println("Sexo: " + dependente.getSexo());
			System.out.println("Data de Nascimento: " + dependente.getDataNascimento());
			System.out.println("Grau de Parentesco: " + dependente.getGrauParentesco());
			
			System.out.println("==================================================");
		}
	}
	
	public static void InserirDependenteComDAO() {
		Scanner sc1 = new Scanner(System.in);
		DependenteDAO cDao = new DependenteJPADAO();
		
		try {
			
			
			System.out.println("Digite o nome do dependente:");
			String nome = sc1.nextLine();
			
			System.out.println("Digite seu sexo :");
			String sexo = sc1.nextLine();
			
			System.out.println("Digite a data de nascimento:");
			LocalDate dataNascimento =  LocalDate.parse(sc1.nextLine(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
			
			System.out.println("Digite o grau de parentesco:");
			String grauParentesco = sc1.nextLine();
			
			System.out.println("1 - Pesquisador");
			System.out.println("2 - Secretario");
			System.out.println("3 - Funcionario de Limpeza");
			
			Long opcaoFuncionario = sc1.nextLong();
			
			System.out.println("Digite o id do funcionario:");
			Long funcionarioId = sc1.nextLong();			
			
			
			sc1.nextLine();

			Dependente dependente = new Dependente(null, nome, sexo, dataNascimento, grauParentesco);

			if(opcaoFuncionario == 1) {
				
				if(!PesquisadorController.existPesquisadorComDAO(funcionarioId)) {
					throw new Exception("Pesquisador nao encontrado.");
				}
					
				PesquisadorDAO pDao = new PesquisadorJPADAO();
				Pesquisador p1 = pDao.find(funcionarioId);
				dependente.setFuncionario(p1);
		
			}else if(opcaoFuncionario == 2) {
					
				if(!SecretarioController.existSecretarioComDAO(funcionarioId)) {
					throw new Exception("Secretario nao encontrado.");
				}
				
				SecretarioDAO pDao = new SecretarioJPADAO();
				Secretario s1 = pDao.find(funcionarioId);
				dependente.setFuncionario(s1);
						
			}else if(opcaoFuncionario == 3) {
				
				if(!FuncionarioLimpezaController.existFuncionarioLimpezaComDAO(funcionarioId)) {
					throw new Exception("Funcionario de Limpeza nao encontrado.");
				}
				
				FuncionarioLimpezaDAO flDao = new FuncionarioLimpezaJPADAO();
				FuncionarioLimpeza fl1 = flDao.find(funcionarioId);
				dependente.setFuncionario(fl1);
					
			}
			
			cDao.beginTransaction();
			cDao.save(dependente);
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

	public static void AtualizarDependenteComDAO() {
		Scanner sc1 = new Scanner(System.in);
		DependenteDAO cDao = new DependenteJPADAO();
		
		try {
				
			System.out.println("Digite o id do Dependente a ser Atualizado:");
			Long id = sc1.nextLong();
			sc1.nextLine();
			
			if(!DependenteController.existDependenteComDAO(id)) {
				throw new Exception("Dependente nao encontrado.");
			}
			
			System.out.println("Digite o nome do dependente:");
			String nome = sc1.nextLine();
			
			System.out.println("Digite seu sexo :");
			String sexo = sc1.nextLine();
			
			System.out.println("Digite a data de nascimento:");
			LocalDate dataNascimento =  LocalDate.parse(sc1.nextLine(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
			
			System.out.println("Digite o grau de parentesco:");
			String grauParentesco = sc1.nextLine();
			
			System.out.println("Digite o id do funcionario:");
			Long funcionarioId = sc1.nextLong();
			sc1.nextLine();
			
			
			System.out.println("1 - Pesquisador");
			System.out.println("2 - Secretario");
			System.out.println("3 - Funcionario de Limpeza");
			
			Long opcaoFuncionario = sc1.nextLong();
			sc1.nextLine();

			Dependente dependente = new Dependente(id, nome, sexo, dataNascimento, grauParentesco);

			if(opcaoFuncionario == 1) {
	
				if(!PesquisadorController.existPesquisadorComDAO(funcionarioId)) {
					throw new Exception("Pesquisador nao encontrado.");
				}
				
				PesquisadorDAO pDao = new PesquisadorJPADAO();
				Pesquisador p1 = pDao.find(funcionarioId);
				dependente.setFuncionario(p1);
	
			}else if(opcaoFuncionario == 2) {
								
				if(!SecretarioController.existSecretarioComDAO(funcionarioId)) {
					throw new Exception("Funcionario nao encontrado.");
				}
				
				SecretarioDAO pDao = new SecretarioJPADAO();
				Secretario s1 = pDao.find(funcionarioId);
				dependente.setFuncionario(s1);
					
			}else if(opcaoFuncionario == 3) {
					
				if(!FuncionarioLimpezaController.existFuncionarioLimpezaComDAO(funcionarioId)) {
					throw new Exception("Funcionario de Limpeza nao encontrado.");
				}
				
				FuncionarioLimpezaDAO flDao = new FuncionarioLimpezaJPADAO();
				FuncionarioLimpeza fl1 = flDao.find(funcionarioId);
				dependente.setFuncionario(fl1);
					
			}
			
			cDao.beginTransaction();
			cDao.save(dependente);
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
	
	public static void deleteDependenteComDAO() {
		DependenteDAO cDao = new DependenteJPADAO();
		Scanner sc1 = new Scanner(System.in);
		try {
			
			System.out.println("Digite o id do Dependente a ser excluido:");
			Long id = sc1.nextLong();
			sc1.nextLine();
			
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
	
	public static Boolean existDependenteComDAO(Long id) {
		DependenteDAO cDao = new DependenteJPADAO();
		Dependente Dependente = cDao.find(id);
		
		cDao.close();
		if(Dependente == null)
			return false;
		else 
			return true;
	}
	
	public static void findByIdDependenteComDAO() {
		Scanner sc1 = new Scanner(System.in);
		try {
			
			System.out.println("Digite o id do Dependente:");
			Long id = sc1.nextLong();
			
			DependenteDAO cDao = new DependenteJPADAO();
			Dependente dependente = cDao.find(id);
			cDao.close();
			
			System.out.println("==================================================");

			System.out.println("Id Funcionario: " + dependente.getFuncionario().getId());
			System.out.println("Nome Funcionario: " + dependente.getFuncionario().getNome());
			System.out.println("Id: " + dependente.getId());
			System.out.println("Nome: " + dependente.getNome());
			System.out.println("Sexo: " + dependente.getSexo());
			System.out.println("Data de Nascimento: " + dependente.getDataNascimento());
			System.out.println("Grau de Parentesco: " + dependente.getGrauParentesco());
			
			System.out.println("==================================================");
			
		}catch(Exception e) {
			System.out.println("\n \n"+"\t \t Erro: Busca nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");

		}

	}
	
}
