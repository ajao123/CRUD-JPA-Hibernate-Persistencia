package com.allisson;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.allisson.controllers.DepartamentoController;
import com.allisson.controllers.DependenteController;
import com.allisson.controllers.FuncionarioLimpezaController;
import com.allisson.controllers.PesquisadorController;
import com.allisson.controllers.ProjetoController;
import com.allisson.controllers.SecretarioController;
import com.allisson.controllers.TrabalhoController;

public class application {


	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 

	public static void main(String[] args) {
		Scanner sc1;
		Boolean sair = true;
		Integer opcao = null;

    	

    	printMenu(); 
    	
    	while(sair) {
    		sc1 = new Scanner(System.in); 
    		try {
    			System.out.println(" 23 - Ver o menu novamente");
        		opcao = sc1.nextInt();
        		
        		switch(opcao) {
        		
        			case 1:
        				
        				System.out.println("1 - Adicionar Pesquisador");
        				System.out.println("2 - Adicionar Secretario");
        				System.out.println("3 - Adicionar Funcionario de Limpeza");
        				opcao = sc1.nextInt();
        				
        				if(opcao == 1) {
        						
        					PesquisadorController.InserirPesquisadorComDAO();
        					
        				}else if(opcao == 2) {
        					
        					SecretarioController.InserirSecretarioComDAO();
        					
        				}else if(opcao == 3){
        					
        					FuncionarioLimpezaController.InserirFuncionarioLimpezaComDAO();
        					
        				}else {
        					System.out.println("Opcao invalida.");
        				}
        				
        				break;
        				
        			case 2:
        					
        				System.out.println("1 - Buscar Pesquisador");
        				System.out.println("2 - Buscar Secretario");
        				System.out.println("3 - Buscar Funcionario de Limpeza");
        				opcao = sc1.nextInt();
        				
        				if(opcao == 1) {
        						
        					PesquisadorController.findByIdPesquisadorComDAO();
        					
        				}else if(opcao == 2) {
        					
        					SecretarioController.findByIdSecretarioComDAO();
        					
        				}else if(opcao == 3){
        					
        					FuncionarioLimpezaController.findByIdFLComDAO();
        					
        				}else {
        					System.out.println("Opcao invalida.");
        				}
        				
            			break;
            			
        			case 3:
        				
        				System.out.println("1 - Deletar Pesquisador");
        				System.out.println("2 - Deletar Secretario");
        				System.out.println("3 - Deletar Funcionario de Limpeza");
        				opcao = sc1.nextInt();
        				
        				if(opcao == 1) {
        						
        					PesquisadorController.deletePesquisadorComDAO();
        					
        				}else if(opcao == 2) {
        					
        					SecretarioController.deleteSecretarioComDAO();
        					
        				}else if(opcao == 3){
        					
        					FuncionarioLimpezaController.deleteFuncionarioLimpezaComDAO();
        					
        				}else {
        					System.out.println("Opcao invalida.");
        				}
        				
            			break;
            			
        			case 4:
        				
        				System.out.println("1 - Buscar Pesquisadores");
        				System.out.println("2 - Buscar Secretarios");
        				System.out.println("3 - Buscar Funcionarios de Limpeza");
        				opcao = sc1.nextInt();
        				
        				if(opcao == 1) {
    						
        					PesquisadorController.buscarPesquisadorComDAO();
        					
        				}else if(opcao == 2) {
        					
        					SecretarioController.buscarSecretarioComDAO();
        					
        				}else if(opcao == 3){
        					
        					FuncionarioLimpezaController.buscarFuncionarioLimpezaComDAO();
        					
        				}else {
        					System.out.println("Opcao invalida.");
        				}
        			
            			break;
            			
        			case 5:
        					DepartamentoController.InserirDepartamentoComDAO();
            			break;
            			
        			case 6:
        				DepartamentoController.findByIdDepartamentoComDAO();
            			break;
            			
        			case 7:
        				DepartamentoController.deleteDepartamentoComDAO();
            			break;
            			
        			case 8:
        				DepartamentoController.buscarDepartamentoComDAO();
            			break;
            			
        			case 9:
        				ProjetoController.InserirProjetoComDAO();
            			break;
            			
        			case 10:
        				ProjetoController.findByIdProjetoComDAO();
        				break;
        				
        			case 11:
        				ProjetoController.deleteProjetoComDAO();
        				break;
        				
        			case 12:
        				ProjetoController.buscarProjetoComDAO();
        				break
        				;
        			case 13:
        				TrabalhoController.InserirTrabalhoComDAO();
        				break;
        				
        			case 14:
        				TrabalhoController.findByIdTrabalhoComDAO();
        				break;
        				
        			case 15:
        				TrabalhoController.deleteTrabalhoComDAO();
        				break;
        				
        			case 16:
        				TrabalhoController.buscarTrabalhoComDAO();
        				break;
        			case 17:
        				DependenteController.InserirDependenteComDAO();
        				break;
        			case 18:
        				DependenteController.findByIdDependenteComDAO();
        				break;
        			case 19:
        				DependenteController.deleteDependenteComDAO();
        				break;
        			case 20:
        				DependenteController.buscarDependenteComDAO();
        				break;
        			case 21:	
        				System.out.println("\t Atualizar \n");
        				System.out.println("1 - Pesquisador");
        				System.out.println("2 - Secretario");
        				System.out.println("3 - Funcionario de Limpeza");
        				System.out.println("4 - Departamento");
        				System.out.println("5 - Dependente");
        				System.out.println("6 - Trabalho");
        				System.out.println("7 - Projeto \n");
        				opcao = sc1.nextInt();
        				
        				if(opcao == 1) {
        						
        					PesquisadorController.AtualizarPesquisadorComDAO();
        					
        				}else if(opcao == 2) {
        					
        					SecretarioController.AtualizarSecretarioComDAO();
        					
        				}else if(opcao == 3){
        					
        					FuncionarioLimpezaController.AtualizarFuncionarioLimpezaComDAO();
        					
        				}else if(opcao == 4){
        					
        					DepartamentoController.AtualizarDepartamentoComDAO();
        					
        				}else if(opcao == 5){
        					
        					DependenteController.AtualizarDependenteComDAO();
        					
        				}else if(opcao == 6){
        					
        					TrabalhoController.AtualizarTrabalhoComDAO();
        					
        				}else if(opcao == 7){
        					
        					ProjetoController.AtualizarProjetoComDAO();
        					
        				}
        				break;
        			case 22:
        				sair = false;
        				break;
        			case 23:
        				printMenu();
        				break;
        				
        			default:
        				System.out.println("Opção inválida.");
        				break;
        				
        		
        		}
    		}catch(Exception e) {
    			System.out.println("\n \n" + "\t \t" +"Erro: Opcao Invalida."+"\n \n");
    		}
    	}

	}
	
	public static void printMenu() {
		System.out.println(" 1  - Adicionar Funcionario");
		System.out.println(" 2  - Buscar Funcionario");
		System.out.println(" 3  - Deletar Funcionario");
		System.out.println(" 4  - Buscar Funcionarios");
		System.out.println(" 5  - Adicionar Departamento");
		System.out.println(" 6  - Buscar Departamento");
		System.out.println(" 7  - Deletar Departamento");
		System.out.println(" 8  - Buscar Departamentos");
		System.out.println(" 9  - Adicionar Projeto");
		System.out.println(" 10 - Buscar Projeto");
		System.out.println(" 11 - Deletar Projeto");
		System.out.println(" 12 - Buscar Projetos");
		System.out.println(" 13 - Adicionar Trabalho");
		System.out.println(" 14 - Buscar Trabalho");
		System.out.println(" 15 - Deletar Trabalho");
		System.out.println(" 16 - Buscar Trabalhos");
		System.out.println(" 17 - Adicionar Dependente");
		System.out.println(" 18 - Buscar Dependente");
		System.out.println(" 19 - Deletar Dependente");
		System.out.println(" 20 - Buscar Dependentes");
		System.out.println(" 21 - Atualizar");
		System.out.println(" 22 - Sair do sistema");
	}

}
