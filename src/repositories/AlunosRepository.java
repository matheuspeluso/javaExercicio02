package repositories;

import java.util.ArrayList;
import java.util.List;

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
	
	public void excluir(Integer id) {
		try {
			var connection = ConnectionFactory.getConnection();
			
			var statement = connection.prepareStatement("DELETE FROM aluno WHERE idaluno=?");
			statement.setInt(1,id);
			statement.execute();
			connection.close();
			
			System.out.println("\nALUNO EXCLUIDO COM SUCESSO!");
		}
		catch(Exception e) {
			System.out.println("\nFalha ao excluir aluno!");
			System.out.println(e.getMessage());
		}
	}
	
	public List<Aluno> consultar(){
		var lista = new ArrayList<Aluno>();
		
		try {
			var connection = ConnectionFactory.getConnection();
			
			var statement = connection.prepareStatement("SELECT idaluno, nome, matricula, cpf FROM aluno ORDER BY nome");
			var result = statement.executeQuery();
			
			while(result.next()) {
				var aluno = new Aluno();
				aluno.setIdAluno(result.getInt("idaluno"));
				aluno.setNome(result.getString("nome"));
				aluno.setMatricula(result.getString("matricula"));
				aluno.setCpf(result.getString("cpf"));
				
				lista.add(aluno);
			}
			connection.close();
			
		}
		catch(Exception e ) {
			System.out.println("\nFalha ao consultar alunos!");
			System.out.println(e.getMessage());
		}
		
		return lista;
	}
}
