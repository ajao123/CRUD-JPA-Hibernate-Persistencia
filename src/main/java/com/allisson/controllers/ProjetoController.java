package com.allisson.controllers;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.allisson.dao.services.DepartamentoDAO;
import com.allisson.dao.services.ProjetoDAO;
import com.allisson.entities.Departamento;
import com.allisson.entities.Projeto;
import com.allisson.entities.Trabalho;
import com.allisson.entities.jpadao.DepartamentoJPADAO;
import com.allisson.entities.jpadao.ProjetoJPADAO;

public class ProjetoController {

	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	
	public static void buscarProjetoComDAO() {
		ProjetoDAO cDao = new ProjetoJPADAO();
		List<Projeto> Projetos = cDao.findAll();
		cDao.close();
		System.out.println("\n \t Projetos \n");
		for(Projeto projeto : Projetos) {
			System.out.println("================================================");
			System.out.println("Projeto " + projeto.getNome() + "\n");
			System.out.println("Id: " + projeto.getId());
			System.out.println("Id do Departamento: " + projeto.getDepartamento().getId());
			System.out.println("Nome do Departamento: " + projeto.getDepartamento().getNome());
			System.out.println("Periodo de projeto: " + projeto.getPeriodoTempo());
			
			System.out.println("\n \t \t Trabalhos \n");
			for(Trabalho trabalho : projeto.getTrabalhos()) {
				System.out.println("Id: " + trabalho.getId());
				System.out.println("Projeto: "+ trabalho.getProjeto().getNome());
				System.out.println("Id do Projeto: "+ trabalho.getProjeto().getId());
				System.out.println("Pesquisador: " + trabalho.getPesquisador().getNome());
				System.out.println("Id do Pesquisador: "+trabalho.getPesquisador().getId());
				System.out.println("Departamento Responsavel: "+ trabalho.getProjeto().getDepartamento().getNome());
				System.out.println("Id do Departamento Responsavel: "+ trabalho.getProjeto().getDepartamento().getId());
				System.out.println("Area(Atuacao): " + trabalho.getPesquisador().getAreaAtuacao());
				System.out.println("Horas Semanais: " + trabalho.getHorasSemanais());
			}
			System.out.println("================================================");	
		}
		
	}
	
	public static void InserirProjetoComDAO() {
		
		ProjetoDAO cDao = new ProjetoJPADAO();
		Scanner sc1 = new Scanner(System.in);
		try {
			
			System.out.println("Digite o id do Departamento:");
			Long departamentoId = sc1.nextLong();
			sc1.nextLine();
			
			if(!DepartamentoController.existDepartamentoComDAO(departamentoId)) {
				throw new Exception("Departamento nao encontrado.");
			}
			
			System.out.println("Digite o nome do Projeto:");
			String nome = sc1.nextLine();
			
			System.out.println("Digite o periodo de trabalho:");
			String periodoTrabalho = sc1.nextLine();
		
			DepartamentoDAO dDao = new DepartamentoJPADAO();
			Departamento d1 = dDao.find(departamentoId);
			Projeto p = new Projeto(null, nome, periodoTrabalho);
			p.setDepartamento(d1);
			
			cDao.beginTransaction();
			cDao.save(p);
			cDao.commit();
		
				
		}catch(Exception e) {
			cDao.rollback();
			
				System.out.println("\n \n"+"\t \t Erro: Insercao nao pode ser concluida.");
				System.out.println("\t \t [" + e.getMessage() + "] \n \n");
			
		} finally {
			cDao.close();
		}
		System.out.println("===========================================");
	}
	
	public static void AtualizarProjetoComDAO() {
		
		ProjetoDAO cDao = new ProjetoJPADAO();
		Scanner sc1 = new Scanner(System.in);
		try {
			
			System.out.println("Digite o id do Projeto a ser atualizado:");
			Long id = sc1.nextLong();
			
			if(!ProjetoController.existProjetoComDAO(id)) {
				throw new Exception("Projeto nao encontrado.");
			}
			
			System.out.println("Digite o id do Departamento:");
			Long departamentoId = sc1.nextLong();
			sc1.nextLine();
			
			if(!DepartamentoController.existDepartamentoComDAO(departamentoId)) {
				throw new Exception("Departamento nao encontrado.");
			}
			
			System.out.println("Digite o nome do Projeto:");
			String nome = sc1.nextLine();
			
			System.out.println("Digite o periodo de trabalho:");
			String periodoTrabalho = sc1.nextLine();
			
		
			DepartamentoDAO dDao = new DepartamentoJPADAO();
			Departamento d1 = dDao.find(departamentoId);
			Projeto p = new Projeto(id, nome, periodoTrabalho);
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

	public static void deleteProjetoComDAO() {
		ProjetoDAO cDao = new ProjetoJPADAO();
		Scanner sc1 = new Scanner(System.in);
		try {
			
			System.out.println("Digite o id do Projeto a ser excluido:");
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

	public static Boolean existProjetoComDAO(Long id) {
		ProjetoDAO cDao = new ProjetoJPADAO();
		Projeto Projeto = cDao.find(id);
		
		cDao.close();
		if(Projeto == null)
			return false;
		else 
			return true;
	}
	
	public static void findByIdProjetoComDAO() {
		
		Scanner sc1 = new Scanner(System.in);
		try {
			System.out.println("Digite o id do Projeto:");
			Long id = sc1.nextLong();
			
			ProjetoDAO cDao = new ProjetoJPADAO();
			Projeto projeto = cDao.find(id);
			cDao.close();
			
			System.out.println("================================================");
			System.out.println("Projeto " + projeto.getNome() + "\n");
			System.out.println("Id: " + projeto.getId());
			System.out.println("Id do Departamento: " + projeto.getDepartamento().getId());
			System.out.println("Nome do Departamento: " + projeto.getDepartamento().getNome());
			System.out.println("Periodo de projeto: " + projeto.getPeriodoTempo());
			
			System.out.println("\n \t \t Trabalhos \n");
			for(Trabalho trabalho : projeto.getTrabalhos()) {
				System.out.println("Id: " + trabalho.getId());
				System.out.println("Projeto: "+ trabalho.getProjeto().getNome());
				System.out.println("Id do Projeto: "+ trabalho.getProjeto().getId());
				System.out.println("Pesquisador: " + trabalho.getPesquisador().getNome());
				System.out.println("Id do Pesquisador: "+trabalho.getPesquisador().getId());
				System.out.println("Departamento Responsavel: "+ trabalho.getProjeto().getDepartamento().getNome());
				System.out.println("Id do Departamento Responsavel: "+ trabalho.getProjeto().getDepartamento().getId());
				System.out.println("Area(Atuacao): " + trabalho.getPesquisador().getAreaAtuacao());
				System.out.println("Horas Semanais: " + trabalho.getHorasSemanais());
			}
			System.out.println("================================================");	
		}catch(Exception e) {
			System.out.println("\n \n"+"\t \t Erro: Busca nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");		}
	}
	
}
