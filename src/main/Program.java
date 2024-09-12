package main;

import java.util.Scanner;

import controllers.AlunoController;

public class Program {
	//TODO criar as outras operações como excluir editar e consultar 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\nSISTEMA DE CADASTRO DE ALUNOS!\n");

		System.out.println("(1) CADASTRAR ALUNO");
		System.out.println("(2) ALTERAR ALUNO");
		System.out.println("(3) EXCLUIR ALUNO");

		System.out.println("\nINFORME A OPÇÃO DESEJADA: ");
		var opcao = scanner.nextLine();

		var alunoController = new AlunoController();

		switch (opcao) {
		case "1":
			alunoController.inserirAluno();
			break;
		case "2":
			alunoController.alterarAluno();
		case "3":
			alunoController.excluirAluno();
		}
		

		System.out.println("\nDESEJA CONTINUAR (S/N): ");
		var continuar = scanner.nextLine();

		if (continuar.equalsIgnoreCase("S")) {
			main(args);
		} else {
			System.out.println("\nFIM DO PROGRAMA!");
		}
	}

}
