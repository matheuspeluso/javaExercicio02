package repositories;

import entities.Aluno;
import factories.ConnectionFactory;

public class AlunosRepository {
	public void cadastrar(Aluno aluno) {
		try {
			var connection = ConnectionFactory.getConnection();
			
			var statement = connection.prepareStatement("INSERT INTO aluno(nome, matricula, cpf) VALUES(?,?,?)");
			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getMatricula());
			statement.setString(3, aluno.getCpf());
			
			statement.execute();
			connection.close();
			System.out.println("ALUNO CADASTRADO COM SUCESSO!");
		}
		catch(Exception e ) {
			System.out.println("\nFalha ao cadastrar aluno!");
			System.out.println(e.getMessage());
		}
	}
}
