package com.allisson.controllers;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import com.allisson.dao.services.DepartamentoDAO;
import com.allisson.entities.Departamento;
import com.allisson.entities.Dependente;
import com.allisson.entities.FuncionarioLimpeza;
import com.allisson.entities.Pesquisador;
import com.allisson.entities.Projeto;
import com.allisson.entities.Secretario;
import com.allisson.entities.Trabalho;
import com.allisson.entities.jpadao.DepartamentoJPADAO;

public class DepartamentoController {

	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


	
	public static void buscarDepartamentoComDAO() {
		
		
		DepartamentoDAO cDao = new DepartamentoJPADAO();
		List<Departamento> Departamentos = cDao.findAll();
		cDao.close();
		
		try {
			System.out.println("\n \t Departamentos \n");
			
				for(Departamento departamento : Departamentos) {
					System.out.println("===========================================================");
					System.out.println("Id: " + departamento.getId());
					System.out.println("Nome: " + departamento.getNome()+"\n");
					System.out.println("Funcionarios \n");
					System.out.println("\t Pesquisadores \n");
					for(Pesquisador pesquisador : departamento.getPesquisadores()) {
						
						System.out.println("\t \t Pesquisador " + pesquisador.getNome() + "\n");
						System.out.println("\t \t \t Id: " + pesquisador.getId());
						System.out.println("\t \t \t Endereco: " + pesquisador.getEndereco());
						System.out.println("\t \t \t Sexo: " + pesquisador.getSexo());
						System.out.println("\t \t \t Data de Nascimento: " + pesquisador.getDataNascimento());
						System.out.println("\t \t \t Salario: " + pesquisador.getSalario());
						System.out.println("\t \t \t Area de Atuacao: " + pesquisador.getAreaAtuacao());
						
						System.out.println("\t \t \t Dependentes \n");
						for(Dependente dependente : pesquisador.getDependentes()) {
							
							System.out.println("\t \t \t \t Dependente " + dependente.getNome() + "\n");
							System.out.println("\t \t \t \t \t Id: " + dependente.getId());
							System.out.println("\t \t \t \t \t Sexo: " + dependente.getSexo());
							System.out.println("\t \t \t \t \t Data de Nascimento: " + dependente.getDataNascimento());
							System.out.println("\t \t \t \t \t Grau Parentesco: " + dependente.getGrauParentesco());
						
						}
						System.out.println("\n");
					}
					System.out.println("\n");
					
					System.out.println("\t Secretarios \n");
					for(Secretario secretario : departamento.getSecretarios()) {
						System.out.println("\t \t Secretario " + secretario.getNome() + "\n");
						System.out.println("\t \t \t Id: " + secretario.getId());
						System.out.println("\t \t \t Endereco: " + secretario.getEndereco());
						System.out.println("\t \t \t Sexo: " + secretario.getSexo());
						System.out.println("\t \t \t Data de Nascimento: " +secretario.getDataNascimento());
						System.out.println("\t \t \t Salario: " + secretario.getSalario());
						System.out.println("\t \t \t Grau de Escolaridade: " + secretario.getGrauEscolaridade());
						
						System.out.println("\t \t \t Dependentes \n");
						for(Dependente dependente : secretario.getDependentes()) {
							
							System.out.println("\t \t \t \t Dependente " + dependente.getNome() + "\n");
							System.out.println("\t \t \t \t \t Id: " + dependente.getId());
							System.out.println("\t \t \t \t \t Sexo: " + dependente.getSexo());
							System.out.println("\t \t \t \t \t Data de Nascimento: " + dependente.getDataNascimento());
							System.out.println("\t \t \t \t \t Grau Parentesco: " + dependente.getGrauParentesco());
						
						}
						System.out.println("\n");
					}
					System.out.println("\n");
					
					System.out.println("\t Funcionarios de Limpeza \n");
					for(FuncionarioLimpeza fl : departamento.getFuncionariosLimpeza()) {
						System.out.println("\t \t Funcionario " + fl.getNome() + "\n");
						System.out.println("\t \t \t Id: " + fl.getId());
						System.out.println("\t \t \t Endereco: " + fl.getEndereco());
						System.out.println("\t \t \t Sexo: " + fl.getSexo());
						System.out.println("\t \t \t Data de Nascimento: " + fl.getDataNascimento());
						System.out.println("\t \t \t Salario: " + fl.getSalario());
						System.out.println("\t \t \t Informacoes do Supervisor: " + fl.getSupervisorInformacoes());
						System.out.println("\t \t \t Cargo: " + fl.getCargo());
						System.out.println("\t \t \t Jornada de Trabalho: " + fl.getJornadaTrabalho());
						
						System.out.println("\t \t \t Dependentes \n");
						for(Dependente dependente : fl.getDependentes()) {
							
							System.out.println("\t \t \t \t Dependente " + dependente.getNome() + "\n");
							System.out.println("\t \t \t \t \t Id: " + dependente.getId());
							System.out.println("\t \t \t \t \t Sexo: " + dependente.getSexo());
							System.out.println("\t \t \t \t \t Data de Nascimento: " + dependente.getDataNascimento());
							System.out.println("\t \t \t \t \t Grau Parentesco: " + dependente.getGrauParentesco());
							System.out.println("\n");
						}
						System.out.println("\n");
						
					}
					
					System.out.println("\n");
					
					System.out.println("Projetos \n");
					for(Projeto projeto : departamento.getProjetos()) {
						System.out.println("\t Projeto " + projeto.getNome() + "\n");
						System.out.println("\t \t Id: " + projeto.getId());
						System.out.println("\t \t Id do Departamento: " + projeto.getDepartamento().getId());
						System.out.println("\t \t Nome do Departamento: " + projeto.getDepartamento().getNome());
						System.out.println("\t \t Periodo de projeto: " + projeto.getPeriodoTempo());
						System.out.println("\n");
						System.out.println("\t \t Trabalhos \n");
						for(Trabalho trabalho : projeto.getTrabalhos()) {
							System.out.println("\t \t \t Id: " + trabalho.getId());
							System.out.println("\t \t \t Projeto: "+ trabalho.getProjeto().getNome());
							System.out.println("\t \t \t Pesquisador: " + trabalho.getPesquisador().getNome());
							System.out.println("\t \t \t Id do Pesquisador: "+trabalho.getPesquisador().getId());
							System.out.println("\t \t \t Area(Atuacao): " + trabalho.getPesquisador().getAreaAtuacao());
							System.out.println("\t \t \t Horas Semanais: " + trabalho.getHorasSemanais());
							System.out.println("\n");
						}
						System.out.println("\n");
					}
					System.out.println("\n");
					System.out.println("===========================================================");
				}
		}catch(Exception e) {
			System.out.println("\n \n"+"\t \t Erro: Busca nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");
			
		}

	}
	
	public static void InserirDepartamentoComDAO() {
	
		DepartamentoDAO cDao = new DepartamentoJPADAO();
		Scanner sc1 = new Scanner(System.in);
		try {
			
			cDao.beginTransaction();
			System.out.println("Digite o nome do Departamento:");
			String nome = sc1.nextLine();
			cDao.save(new Departamento(null, nome));
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
	
	public static void AtualizarDepartamentoComDAO() {
		
		DepartamentoDAO cDao = new DepartamentoJPADAO();
		
		Scanner sc1 = new Scanner(System.in);
		try {


			System.out.println("Digite o id do Departamento a ser atualizado:");
			Long id = sc1.nextLong();
			sc1.nextLine();
		
			if(!DepartamentoController.existDepartamentoComDAO(id)) {
				throw new Exception("Departamento nao encontrado.");
			}
			
			
			System.out.println("Digite o nome do Departamento:");
			String nome = sc1.nextLine();
				
				cDao.beginTransaction();
				cDao.save(new Departamento(id, nome));
				cDao.commit();
		
		} catch(Exception e) {
			cDao.rollback();
		//	e.printStackTrace();
			System.out.println("\n \n"+"\t \t Erro: Atualizacao nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");

			
		} finally {
			cDao.close();
		}
		System.out.println("===========================================");
	}
	
	public static void deleteDepartamentoComDAO() {
		DepartamentoDAO cDao = new DepartamentoJPADAO();
		Scanner sc1 = new Scanner(System.in);
		try {
			
			System.out.println("Digite o id do Departamento a ser excluido:");
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

	public static Boolean existDepartamentoComDAO(long id) {
		DepartamentoDAO cDao = new DepartamentoJPADAO();
		Departamento departamento = cDao.find(id);
		
		cDao.close();
		if(departamento == null)
			return false;
		else 
			return true;
	}

	public static void findByIdDepartamentoComDAO() {
		Scanner sc1 = new Scanner(System.in);	
		try {
			
			System.out.println("Digite o id do Departamento:");
			Long id = sc1.nextLong();
			
			if(!DepartamentoController.existDepartamentoComDAO(id)) {
				throw new Exception("Departamento nao encontrado.");
			}
			
			DepartamentoDAO cDao = new DepartamentoJPADAO();
			Departamento departamento = cDao.find(id);
			cDao.close();
			
			System.out.println("Id: " + departamento.getId());
			System.out.println("Nome: " + departamento.getNome());
			
			System.out.println("\t \nPesquisadores \n");
			for(Pesquisador pesquisador : departamento.getPesquisadores()) {
				System.out.println("\t Pesquisador " + pesquisador.getNome() + "\n");
				System.out.println("\t \t Endereco: " + pesquisador.getEndereco());
				System.out.println("\t \t Sexo: " + pesquisador.getSexo());
				System.out.println("\t \t Data de Nascimento: " + pesquisador.getDataNascimento());
				System.out.println("\t \t Salario: " + pesquisador.getSalario());
				System.out.println("\t \t Area de Atuacao: " + pesquisador.getAreaAtuacao()+"\n \n");
			}
			
			System.out.println("\t \nSecretarios \n");
			for(Secretario secretario : departamento.getSecretarios()) {
				System.out.println("\t Secretario " + secretario.getNome() + "\n");
				System.out.println("\t \t Endereco: " + secretario.getEndereco());
				System.out.println("\t \t Sexo: " + secretario.getSexo());
				System.out.println("\t \t Data de Nascimento: " +secretario.getDataNascimento());
				System.out.println("\t \t Salario: " + secretario.getSalario());
				System.out.println("\t \t Grau de Escolaridade: " + secretario.getGrauEscolaridade()+"\n \n");
			}
			
			System.out.println("\t \nFuncionarios de Limpeza \n");
			for(FuncionarioLimpeza fl : departamento.getFuncionariosLimpeza()) {
				System.out.println("\t Funcionario " + fl.getNome() + "\n");
				System.out.println("\t \t Endereco: " + fl.getEndereco());
				System.out.println("\t \t Sexo: " + fl.getSexo());
				System.out.println("\t \t Data de Nascimento: " + fl.getDataNascimento());
				System.out.println("\t \t Salario: " + fl.getSalario());
				System.out.println("\t \t Informacoes do Supervisor: " + fl.getSupervisorInformacoes());
				System.out.println("\t \t Cargo: " + fl.getCargo());
				System.out.println("\t \t Jornada de Trabalho: " + fl.getJornadaTrabalho()+"\n \n");

			}
			
			System.out.println("Projetos \n");
			for(Projeto projeto : departamento.getProjetos()) {
				System.out.println("\t Projeto " + projeto.getNome() + "\n");
				System.out.println("\t \t Id: " + projeto.getId());
				System.out.println("\t \t Id do Departamento: " + projeto.getDepartamento().getId());
				System.out.println("\t \t Nome do Departamento: " + projeto.getDepartamento().getNome());
				System.out.println("\t \t Periodo de projeto: " + projeto.getPeriodoTempo());
				System.out.println("\n");
				System.out.println("\t \t Trabalhos \n");
				for(Trabalho trabalho : projeto.getTrabalhos()) {
					System.out.println("\t \t \t Id: " + trabalho.getId());
					System.out.println("\t \t \t Projeto: "+ trabalho.getProjeto().getNome());
					System.out.println("\t \t \t Pesquisador: " + trabalho.getPesquisador().getNome());
					System.out.println("\t \t \t Id do Pesquisador: "+trabalho.getPesquisador().getId());
					System.out.println("\t \t \t Area(Atuacao): " + trabalho.getPesquisador().getAreaAtuacao());
					System.out.println("\t \t \t Horas Semanais: " + trabalho.getHorasSemanais());
					System.out.println("\n");
				}
				System.out.println("\n");
			}
		}catch(Exception e) {
			
			System.out.println("\n \n"+"\t \t Erro: Busca nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");
			
		}
	}
}
