package controllers;

import java.util.Scanner;

import entities.Aluno;
import repositories.AlunosRepository;

public class AlunoController {
	private Scanner scanner = new Scanner(System.in);

	public void inserirAluno() {
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
			alunosRepository.inserir(aluno);

		} catch (Exception e) {
			System.out.println("\nFalha ao cadastrar Aluno");
			System.out.println(e.getMessage());
		}

	}

	public void alterarAluno() {
		try {
			System.out.println("\nATUALIZAÇÃO DE ALUNOS: \n");
			System.out.println("INFORME O ID ALUNO: ");
			var id = Integer.parseInt(scanner.nextLine());

			var alunosRepository = new AlunosRepository();
			var aluno = alunosRepository.obterPorId(id);

			if (aluno != null) {
				System.out.println("\nDADOS DO ALUNO: ");
				System.out.println("ID........: " + aluno.getIdAluno());
				System.out.println("NOME........: " + aluno.getNome());
				System.out.println("MATRICULA........: " + aluno.getMatricula());
				System.out.println("CPF........: " + aluno.getCpf());
				System.out.println("");

				System.out.println("ALTERE O NOME...: ");
				aluno.setNome(scanner.nextLine());

				System.out.println("ALTERE A MATRICULA: ");
				aluno.setMatricula(scanner.nextLine());

				System.out.println("ALTERE O CPF: ");
				aluno.setCpf(scanner.nextLine());

				alunosRepository.alterar(aluno);

			} else {
				System.out.println("\nAluno não encontrado. Verifique o ID informado.");
			}
		} catch (Exception e) {
			System.out.println("\nFalha ao atualizar aluno!");
			System.out.println(e.getMessage());
		}
	}

	public void excluirAluno() {
		try {
			System.out.println("\nEXCLUSÃO DE ALUNOS:");

			System.out.println("INFORME O ID DO ALUNO: ");
			var id = Integer.parseInt(scanner.nextLine());

			var alunosRepository = new AlunosRepository();
			var aluno = alunosRepository.obterPorId(id);

			if (aluno != null) {
				System.out.println("\nDADOS DO ALUNO:");
				System.out.println("ID........: " + aluno.getIdAluno());
				System.out.println("NOME........: " + aluno.getNome());
				System.out.println("MATRICULA........: " + aluno.getMatricula());
				System.out.println("CPF........: " + aluno.getCpf());
				System.out.println("");

				alunosRepository.excluir(aluno.getIdAluno());
			} else {
				System.out.println("\nAluno não encontrado. Verifique o ID informado.");
			}
		} catch (Exception e) {
			System.out.println("\nFalha ao excluir aluno!");
			System.out.println(e.getMessage());
		}
	}

	public void consultarAlunos() {
		try {
			System.out.println("\nCONSULTA DE ALUNOS: ");
			var alunosRepository = new AlunosRepository();
			var lista = alunosRepository.consultar();

			for (Aluno aluno : lista) {
				System.out.println("ID: " + aluno.getIdAluno());
				System.out.println("NOME: " + aluno.getNome());
				System.out.println("MATRICULA: " + aluno.getMatricula());
				System.out.println("CPF: " + aluno.getCpf());
				System.out.println("");

			}
		} catch (Exception e) {
			System.out.println("\nFalha ao consultar alunos!");
			System.out.println(e.getMessage());
		}
	}
}
