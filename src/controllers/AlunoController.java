package controllers;

import java.util.Scanner;

import entities.Aluno;
import repositories.AlunosRepository;

public class AlunoController {
	private Scanner scanner = new Scanner(System.in);
	
	public void cadastrarProduto() {
		try {
			System.out.println("CADASTRO DE ALUNOS........: ");
			System.out.println("NOME DO ALUNO........: ");
			var nome = scanner.nextLine();
			
			System.out.println("MATRÍCULA........: ");
			var matricula = scanner.nextLine();
			
			System.out.println("CPF........: ");
			var cpf = scanner.nextLine();
			
			var aluno = new Aluno(nome, matricula, cpf);
			
			
			var alunosRepository = new AlunosRepository();
			alunosRepository.cadastrar(aluno);
			
		}
		catch(Exception e ) {
			System.out.println("\nFalha ao cadastrar Aluno");
			System.out.println(e.getMessage());
		}
		
	}
}
