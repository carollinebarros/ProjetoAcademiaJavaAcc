package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import negocio.Pessoa;

public class PessoaDAO {
	
		private Connection conn = null;

		public PessoaDAO() {	
			new ConexaoBD();
			conn = ConexaoBD.getConnection();		
		}

		public void adicionar(Pessoa pessoa) {			

			String sql = "INSERT INTO pessoa(nome,cpf, idade) VALUES(?,?,?)";
			System.out.println(sql);

			try {
				PreparedStatement stmt = conn.prepareStatement(sql);		
				stmt.setString(1, pessoa.getNome());			
				stmt.setString(2, pessoa.getCpf()); 
				stmt.setInt(3, pessoa.getIdade());

				stmt.execute();
				stmt.close();

				System.out.println("CADASTRO REALIZADO COM SUCESSO!");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public void deletar(String cpf) {
			String sql = "DELETE FROM pessoa WHERE cpf=?";
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);						
				stmt.setString(1, cpf); 
				stmt.execute();
				stmt.close();

				System.out.println("PESSOA REMOVIDA COM SUCESSO!");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public List<Pessoa> listar() {
			
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			
			String sql = "SELECT * FROM pessoa";
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()){
					Pessoa pessoa = new Pessoa();
					pessoa.setNome(rs.getString("nome"));  
					pessoa.setCpf(rs.getString("cpf"));
					pessoa.setIdade(rs.getInt("idade"));					
					pessoas.add(pessoa);
				}
				
				rs.close();
				stmt.close();
				return pessoas;
			} catch (SQLException e) {			
				throw new RuntimeException(e);
			}		
		}

	
	}



