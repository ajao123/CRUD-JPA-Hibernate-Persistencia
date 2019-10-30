package com.allisson.controllers;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.allisson.dao.services.PesquisadorDAO;
import com.allisson.dao.services.ProjetoDAO;
import com.allisson.dao.services.TrabalhoDAO;
import com.allisson.entities.Pesquisador;
import com.allisson.entities.Projeto;
import com.allisson.entities.Trabalho;
import com.allisson.entities.jpadao.PesquisadorJPADAO;
import com.allisson.entities.jpadao.ProjetoJPADAO;
import com.allisson.entities.jpadao.TrabalhoJPADAO;

public class TrabalhoController {

	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	
	public static void buscarTrabalhoComDAO() {
		TrabalhoDAO cDao = new TrabalhoJPADAO();
		List<Trabalho> Trabalhos = cDao.findAll();
		cDao.close();
		System.out.println("\n \t Trabalhos \n");
		for(Trabalho trabalho : Trabalhos) {
			System.out.println("===========================================");
			System.out.println("Id: " + trabalho.getId());
			System.out.println("Projeto: "+ trabalho.getProjeto().getNome());
			System.out.println("Id do Projeto: "+ trabalho.getProjeto().getId());
			System.out.println("Pesquisador: " + trabalho.getPesquisador().getNome());
			System.out.println("Id do Pesquisador: "+trabalho.getPesquisador().getId());
			System.out.println("Departamento Responsavel: "+ trabalho.getProjeto().getDepartamento().getNome());
			System.out.println("Id do Departamento Responsavel: "+ trabalho.getProjeto().getDepartamento().getId());
			System.out.println("Area(Atuacao): " + trabalho.getPesquisador().getAreaAtuacao());
			System.out.println("Horas Semanais: " + trabalho.getHorasSemanais());
			System.out.println("===========================================");
			System.out.println("\n");
		}
		
	}
	
	public static void InserirTrabalhoComDAO() {
		
		TrabalhoDAO cDao = new TrabalhoJPADAO();
		Scanner sc1 = new Scanner(System.in);
		try {
			
			System.out.println("Digite o id do Projeto:");
			Long projetoId = sc1.nextLong();
			
			if(!ProjetoController.existProjetoComDAO(projetoId)) {
				throw new Exception("Projeto nao encontrado.");
			}
			
			System.out.println("Digite o id do Pesquisador:");
			Long pesquisadorId = sc1.nextLong();
			
			if(!PesquisadorController.existPesquisadorComDAO(pesquisadorId)) {
				throw new Exception("Pesquisador nao encontrado.");
			}
			
			System.out.println("Digite o numero de horas semanais de trabalho do Pesquisador:");
			Integer horasSemanais = sc1.nextInt();
			
			if(ProjetoController.existProjetoComDAO(projetoId) 
					&& PesquisadorController.existPesquisadorComDAO(pesquisadorId)) {
				
				ProjetoDAO pDao = new ProjetoJPADAO();
				Projeto p1 = pDao.find(projetoId);
				
				PesquisadorDAO pqDao = new PesquisadorJPADAO();
				Pesquisador pq1 = pqDao.find(pesquisadorId);
				
				Trabalho t1 = new Trabalho(null, horasSemanais);
				
				t1.setProjeto(p1);
				t1.setPesquisador(pq1);
				
				cDao.beginTransaction();
				cDao.save(t1);
				cDao.commit();
				
			}else {
				System.out.println("Dados Invalidos");
			}
				
		} catch(Exception e) {
			cDao.rollback();
			System.out.println("\n \n"+"\t \t Erro: Insercao nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");
		} finally {
			cDao.close();
		}
		System.out.println("===========================================");
	}
	
	public static void AtualizarTrabalhoComDAO() {
		
		TrabalhoDAO cDao = new TrabalhoJPADAO();
		Scanner sc1 = new Scanner(System.in);
		try {
			
			System.out.println("Digite o id do Trabalho a ser atualizado:");
			Long id = sc1.nextLong();
			
			if(!TrabalhoController.existTrabalhoComDAO(id)) {
				throw new Exception("Trabalho nao encontrado.");
			}
			
			System.out.println("Digite o id do Projeto:");
			Long projetoId = sc1.nextLong();
			
			if(!ProjetoController.existProjetoComDAO(projetoId)) {
				throw new Exception("Projeto nao encontrado.");
			}

			System.out.println("Digite o id do Pesquisador:");
			Long pesquisadorId = sc1.nextLong();
			
			if(!PesquisadorController.existPesquisadorComDAO(pesquisadorId)) {
				throw new Exception("Pesquisador nao encontrado.");
			}
			
			System.out.println("Digite o numero de horas semanais de trabalho do Pesquisador:");
			Integer horasSemanais = sc1.nextInt();
			
			ProjetoDAO pDao = new ProjetoJPADAO();
			Projeto p1 = pDao.find(projetoId);
			
			PesquisadorDAO pqDao = new PesquisadorJPADAO();
			Pesquisador pq1 = pqDao.find(pesquisadorId);
			
			Trabalho t1 = new Trabalho(id, horasSemanais);
			
			t1.setProjeto(p1);
			t1.setPesquisador(pq1);
			
			cDao.beginTransaction();
			cDao.save(t1);
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
	
	public static void deleteTrabalhoComDAO() {
		TrabalhoDAO cDao = new TrabalhoJPADAO();
		Scanner sc1 = new Scanner(System.in);
		try {

			System.out.println("Digite o id do Trabalho a ser excluido:");
			Long id = sc1.nextLong();
	
				cDao.beginTransaction();
				cDao.deleteById(id);
				cDao.commit();

			System.out.println("===========================================");
	
			
		} catch(Exception e) {
			cDao.rollback();
			System.out.println("\n \n"+"\t \t Erro: Remocao nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");		} finally {
			cDao.close();
		}
	}

	public static Boolean existTrabalhoComDAO(Long id) {
		TrabalhoDAO cDao = new TrabalhoJPADAO();
		Trabalho Trabalho = cDao.find(id);
		
		cDao.close();
		if(Trabalho == null)
			return false;
		else 
			return true;
	}

	public static void findByIdTrabalhoComDAO() {
		
		Scanner sc1 = new Scanner(System.in);
		
		try {
			
			System.out.println("Digite o id do Trabalho:");
			Long id = sc1.nextLong();
			
			TrabalhoDAO cDao = new TrabalhoJPADAO();
			Trabalho trabalho = cDao.find(id);
			cDao.close();
			
			System.out.println("===========================================");
			System.out.println("Id: " + trabalho.getId());
			System.out.println("Projeto: "+ trabalho.getProjeto().getNome());
			System.out.println("Id do Projeto: "+ trabalho.getProjeto().getId());
			System.out.println("Pesquisador: " + trabalho.getPesquisador().getNome());
			System.out.println("Id do Pesquisador: "+trabalho.getPesquisador().getId());
			System.out.println("Departamento Responsavel: "+ trabalho.getProjeto().getDepartamento().getNome());
			System.out.println("Id do Departamento Responsavel: "+ trabalho.getProjeto().getDepartamento().getId());
			System.out.println("Area(Atuacao): " + trabalho.getPesquisador().getAreaAtuacao());
			System.out.println("Horas Semanais: " + trabalho.getHorasSemanais());
			System.out.println("===========================================");
			System.out.println("\n");
		}catch(Exception e) {
			System.out.println("\n \n"+"\t \t Erro: Busca nao pode ser concluida.");
			System.out.println("\t \t [" + e.getMessage() + "] \n \n");		}
	}
}
