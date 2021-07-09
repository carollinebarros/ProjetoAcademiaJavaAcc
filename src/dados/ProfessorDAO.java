package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import negocio.Pessoa;
import negocio.Professor;


public class ProfessorDAO {
		
	private Connection conn = null;

	public ProfessorDAO() {	
				new ConexaoBD();
				conn = ConexaoBD.getConnection();		
			}

			public void adicionar(Professor professor) {			

				String sql = "INSERT INTO professor(nome,cpf, idade, salario) VALUES(?,?,?,?)";
				System.out.println(sql);

				try {
					PreparedStatement stmt = conn.prepareStatement(sql);		
					stmt.setString(1, professor.getNome());			
					stmt.setString(2, professor.getCpf()); 
					stmt.setInt(3, professor.getIdade());
					stmt.setDouble(4, professor.getSalario());

					stmt.execute();
					stmt.close();

					System.out.println("CADASTRO REALIZADO COM SUCESSO!");
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			
			public void deletar(String cpf) {
				String sql = "DELETE FROM professor WHERE cpf=?";
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
				
				String sql = "SELECT * FROM professor";
				try {
					PreparedStatement stmt = conn.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()){
						Professor professor = new Professor();
						professor.setNome(rs.getString("nome"));  
						professor.setCpf(rs.getString("cpf"));
						professor.setIdade(rs.getInt("idade"));
						professor.setSalario(rs.getDouble("salario"));
						pessoas.add(professor);
					}
					
					rs.close();
					stmt.close();
					return pessoas;
				} catch (SQLException e) {			
					throw new RuntimeException(e);
				}		
			}	
		}


