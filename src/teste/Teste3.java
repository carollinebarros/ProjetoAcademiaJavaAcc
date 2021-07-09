package teste;

import java.util.List;

import dados.PessoaDAO;
import dados.ProfessorDAO;
import negocio.Pessoa;
import negocio.Professor;

public class Teste3 {

	public static void main(String[] args) {
		
		
		System.out.println("+-------------------------------------------+");
		System.out.println("|-------------------JDBC--------------------|");
		System.out.println("+-------------------------------------------+");
				
		//ADICIONAR
		
		System.out.println("+-------------------------------------------+");
		System.out.println("|                 CADASTRO:                 |");
		System.out.println("+-------------------------------------------+");
		
		PessoaDAO db = new PessoaDAO();
		Pessoa pessoa1 = new Pessoa("Pessoa1", "32345678902", 17);
		db.adicionar(pessoa1);
		System.out.println(pessoa1);
		
		PessoaDAO db1 = new PessoaDAO();
		Pessoa pessoa2 = new Pessoa("Pessoa2", "23412345621", 29);
		db1.adicionar(pessoa2 );
		System.out.println(pessoa2);
		
		ProfessorDAO bd = new ProfessorDAO();
		Professor professor1 = new Professor("Pessoa3", "72345678902", 34, 50000);
		bd.adicionar(professor1);
		System.out.println(professor1);
		
		//REMOVER
		
		System.out.println("+-------------------------------------------+");
		System.out.println("|                 REMOVER:                  |");
		System.out.println("+-------------------------------------------+");		
		
		PessoaDAO pessoaDao = new PessoaDAO();
		Pessoa pessoa4 = new Pessoa("Pessoa1", "32345678902", 17);
		pessoaDao.deletar(pessoa4.getCpf());
		System.out.println(pessoa4);
		
		//LISTAR
			
		System.out.println("+-------------------------------------------+");
		System.out.println("|            LISTA DE CADASTRO:             |");
		System.out.println("+-------------------------------------------+");
		System.out.println("+-----------------PESSOA--------------------+");
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> lista = pessoaDAO.listar();
		for (Pessoa pessoa : lista) {
		System.out.println(pessoa);
		}
		System.out.println("+-----------------PROFESSOR-----------------+");
		ProfessorDAO professorDAO = new ProfessorDAO();
		List<Pessoa> lista2 = professorDAO.listar();
		for (Pessoa professor : lista2) {
		System.out.println(professor);
		
	} 
		
 }

}





