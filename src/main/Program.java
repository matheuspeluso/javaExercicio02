package main;

import java.util.Scanner;

import controllers.AlunoController;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\nSISTEMA DE CADASTRO DE ALUNOS!\n");

		System.out.println("(1) CADASTRAR ALUNOS");

		System.out.println("\nINFORME A OPÇÃO DESEJADA: ");
		var opcao = scanner.nextLine();

		var alunoController = new AlunoController();

		switch (opcao) {
		case "1":
			alunoController.cadastrarProduto();
			break;
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
