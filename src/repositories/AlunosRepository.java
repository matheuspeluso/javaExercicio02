package repositories;

import entities.Aluno;
import factories.ConnectionFactory;

public class AlunosRepository {
	public void inserir(Aluno aluno) {
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
	
	
	public void alterar(Aluno aluno) {
		try {
			var connection = ConnectionFactory.getConnection();
			
			var statement = connection.prepareStatement("UPDATE aluno SET nome=?, cpf=?, matricula=? WHERE idaluno=?");
			statement.setString(1, aluno.getNome());
			statement.setString(2,aluno.getCpf());
			statement.setString(3, aluno.getMatricula());
			statement.setInt(4, aluno.getIdAluno());
			statement.execute();
			
			connection.close();
		}
		catch(Exception e ) {
			System.out.println("\nFalha ao atualizar Aluno!");
			System.out.println(e.getMessage());
		}
	}
	
	public Aluno obterPorId(Integer id) {
		Aluno aluno = null;
		
		try {
			var connection = ConnectionFactory.getConnection();
			
			var statement = connection.prepareStatement("SELECT idaluno,nome,matricula,cpf FROM aluno WHERE idaluno=?");
			statement.setInt(1, id);
			var result = statement.executeQuery();
			
			if(result.next()) {
				aluno = new Aluno();
				
				aluno.setIdAluno(result.getInt("idaluno"));
				aluno.setNome(result.getString("nome"));
				aluno.setMatricula(result.getString("matricula"));
				aluno.setCpf(result.getString("cpf"));
			}
			connection.close();
		}
		catch(Exception e ) {
			System.out.println("\nFalha ao consultar id!");
			System.out.println(e.getMessage());
		}
		
		return aluno;
	}
	
}
