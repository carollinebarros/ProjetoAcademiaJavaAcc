package negocio;


public interface RepositorioPessoas {
	
	void inserir(Pessoa pessoa) throws InserirException;
	Pessoa procurar(String numCpf);
	void remover(String numCpf);

}


