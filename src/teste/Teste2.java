package teste;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dados.ConexaoBD;

public class Teste2 {

	public static void main(String[] args) {
		
         Connection conn = null;
         Statement st = null;
         ResultSet rs = null;        
         
         // FOI SÓ UM TESTE P VER SE A CONEXÃO COM O WORKBENCH ESTAVA OK
         // PARA RODAR ESTE TERÁ QUE INSERIR DADOS NO BANCO
         
         
         try {
        	 conn = ConexaoBD.getConnection();
        	 
        	 st = conn.createStatement();
        	 
        	 rs = st.executeQuery("select * from aluno");
        	 
        	 while (rs.next()) {
        		 System.out.println(rs.getString("nome") + "," + rs.getInt("idade"));
         }
	
	}
         catch (SQLException e) {
        	 e.printStackTrace();
         }

     }
}