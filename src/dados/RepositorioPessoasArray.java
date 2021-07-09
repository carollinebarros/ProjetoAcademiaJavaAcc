package dados;

import java.util.Arrays;

import negocio.InserirException;
import negocio.Pessoa;
import negocio.RepositorioPessoas;


public class RepositorioPessoasArray implements RepositorioPessoas {

	private Pessoa[] pessoas;
	private int indice;
	
	
	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public RepositorioPessoasArray(int tamanho) {
		indice = 0;
		pessoas = new Pessoa[tamanho];
	}

	public RepositorioPessoasArray(Pessoa[] pessoas, int indice) {
		this.pessoas = null;
		this.indice = 0;
		
	}

	public void inserir(Pessoa pessoa) throws InserirException {
		if(indice>=pessoas.length) {
			throw new InserirException();			
		}
		
		this.pessoas[indice] = pessoa;
		this.indice++;	
		
	}

	public Pessoa procurar(String numCPF) {
		Pessoa encontrada = null;
		for (int i = 0; i < indice; i++) {
			Pessoa aux = this.pessoas[i];
			if (aux.getCpf().equals(numCPF))
				encontrada = aux;
		}
		return encontrada;
	}

	public void remover(String numCPF) {
		for (int i = 0; i < indice; i++) {
			Pessoa aux = this.pessoas[i];
			if (aux.getCpf().equals(numCPF)) {
				this.pessoas[i] = this.pessoas[indice - 1];
				this.pessoas[indice - 1] = null;
				indice--;
				System.out.println("Posicao disponivel: " + indice);
			}

		}
	}

	@Override
	public String toString() {
		return "PESSOAS CADASTRADAS: \n\n" + Arrays.toString(pessoas);
	}
	
}