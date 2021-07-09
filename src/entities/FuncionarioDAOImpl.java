package entities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FuncionarioDAOImpl implements FuncionarioDAO {
	
	private JDBC banco;
	
	public FuncionarioDAOImpl() {
		
		banco = new JDBC();
	}
	

	@Override
	public void salvar(Funcionario funcionario) {

		String sql = "insert into funcionario values (?,?,?,?);";
		PreparedStatement preparedStatement;
//		int id = funcionario.getId();
//		if(id !=funcionario.getId()) 
			
			try {
			preparedStatement = banco.getConnection().prepareStatement(sql);
			
			preparedStatement.setInt(1, funcionario.getId());
			preparedStatement.setString(2, funcionario.getNome());
			preparedStatement.setString(3, funcionario.getProfissao());
			preparedStatement.setInt(4, funcionario.getSalario());
			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Funcionario funcionario) {
		
		String sql = "update funcionario set salario = 5000 where id = 1;";
		Statement statement;
		
		try {
			statement = banco.getConnection().prepareStatement(sql);
			statement.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void remover(Funcionario funcionario) {

		String sql = "delete from funcionario where nome = 'João';";
		Statement statement;
		
		try {
			statement = banco.getConnection().prepareStatement(sql);
			statement.execute(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
		public ArrayList<Funcionario> listar(){
		
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try {
			
			String sql = "select * from funcionario;";
			PreparedStatement statement = banco.getConnection().prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				
				Funcionario funcionario = new Funcionario();
				
				funcionario.setId(resultSet.getInt(1));
				funcionario.setNome(resultSet.getString(2));
				funcionario.setProfissao(resultSet.getString(3));
				funcionario.setSalario(resultSet.getInt(4));
				funcionarios.add(funcionario);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		return funcionarios;
	}


		@Override
		public Funcionario buscarPorId(int id) {

			Funcionario funcionario = new Funcionario();
			
			try {
				
				String sql = "select * from funcionario where ID = " + id + " ;";
//				String sql = "select * from funcionario where id= 1;";
				PreparedStatement statement = banco.getConnection().prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery(sql);
				
				while(resultSet.next()) {
								
					funcionario.setId(resultSet.getInt(1));
					funcionario.setNome(resultSet.getString(2));
					funcionario.setProfissao(resultSet.getString(3));
					funcionario.setSalario(resultSet.getInt(4));
				
				}
			} catch (SQLException e) {
			
				//e.printStackTrace();
				
			}
			
			return funcionario;
		}	

}
