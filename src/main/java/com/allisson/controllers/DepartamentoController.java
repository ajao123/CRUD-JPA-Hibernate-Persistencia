package com.allisson.controllers;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.allisson.dao.services.DepartamentoDAO;
import com.allisson.entities.Departamento;
import com.allisson.entities.Dependente;
import com.allisson.entities.Funcionario;
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
					
					
					
					for(Funcionario funcionario : departamento.getFuncionarios()) {
						
						System.out.println("\t Id: " + funcionario.getId());
						System.out.println("\t Endereco: " + funcionario.getEndereco());
						System.out.println("\t Sexo: " + funcionario.getSexo());
						System.out.println("\t Data de Nascimento: " + funcionario.getDataNascimento());
						System.out.println("\t Salario: " + funcionario.getSalario());
						
						if(funcionario instanceof Pesquisador) {
							Pesquisador pesquisador = (Pesquisador) funcionario;
							System.out.println("\t Area de Atuacao: " + pesquisador.getAreaAtuacao());
							System.out.println("\t Funcao: Pesquisador");
						}else if(funcionario instanceof Secretario) {
							
							Secretario secretario = (Secretario) funcionario;
							System.out.println("\t Grau de Escolaridade: " + secretario.getGrauEscolaridade());
							System.out.println("\t Funcao: Secretario");
							
						}else if(funcionario instanceof FuncionarioLimpeza) {
							
							FuncionarioLimpeza fl = (FuncionarioLimpeza) funcionario;
							System.out.println("\t Informacoes do Supervisor: " + fl.getSupervisorInformacoes());
							System.out.println("\t Cargo: " + fl.getCargo());
							System.out.println("\t Jornada de Trabalho: " + fl.getJornadaTrabalho());
							System.out.println("\t Funcao: Funcionario de Limpeza");
						}
	
						System.out.println("\t Dependentes \n");
						for(Dependente dependente : funcionario.getDependentes()) {
							
							System.out.println("\t \t Dependente " + dependente.getNome() + "\n");
							System.out.println("\t \t Id: " + dependente.getId());
							System.out.println("\t \t Sexo: " + dependente.getSexo());
							System.out.println("\t \t Data de Nascimento: " + dependente.getDataNascimento());
							System.out.println("\t \t Grau Parentesco: " + dependente.getGrauParentesco());
						
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
			
			System.out.println("===========================================================");
			System.out.println("Id: " + departamento.getId());
			System.out.println("Nome: " + departamento.getNome()+"\n");
			System.out.println("Funcionarios \n");
			
			
			
			for(Funcionario funcionario : departamento.getFuncionarios()) {
				
				System.out.println("\t Id: " + funcionario.getId());
				System.out.println("\t Endereco: " + funcionario.getEndereco());
				System.out.println("\t Sexo: " + funcionario.getSexo());
				System.out.println("\t Data de Nascimento: " + funcionario.getDataNascimento());
				System.out.println("\t Salario: " + funcionario.getSalario());
				
				if(funcionario instanceof Pesquisador) {
					Pesquisador pesquisador = (Pesquisador) funcionario;
					System.out.println("\t Area de Atuacao: " + pesquisador.getAreaAtuacao());
					System.out.println("\t Funcao: Pesquisador");
				}else if(funcionario instanceof Secretario) {
					
					Secretario secretario = (Secretario) funcionario;
					System.out.println("\t Grau de Escolaridade: " + secretario.getGrauEscolaridade());
					System.out.println("\t Funcao: Secretario");
					
				}else if(funcionario instanceof FuncionarioLimpeza) {
					
					FuncionarioLimpeza fl = (FuncionarioLimpeza) funcionario;
					System.out.println("\t Informacoes do Supervisor: " + fl.getSupervisorInformacoes());
					System.out.println("\t Cargo: " + fl.getCargo());
					System.out.println("\t Jornada de Trabalho: " + fl.getJornadaTrabalho());
					System.out.println("\t Funcao: Funcionario de Limpeza");
				}

				System.out.println("\t Dependentes \n");
				for(Dependente dependente : funcionario.getDependentes()) {
					
					System.out.println("\t \t Dependente " + dependente.getNome() + "\n");
					System.out.println("\t \t Id: " + dependente.getId());
					System.out.println("\t \t Sexo: " + dependente.getSexo());
					System.out.println("\t \t Data de Nascimento: " + dependente.getDataNascimento());
					System.out.println("\t \t Grau Parentesco: " + dependente.getGrauParentesco());
				
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
		}catch(Exception e) {
			
			System.out.println("\n \n"+"\t \t Erro: Busca nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");
			
		}
	}
}
