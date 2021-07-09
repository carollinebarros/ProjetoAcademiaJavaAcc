package dados;

import java.util.ArrayList;
import java.util.List;

import negocio.Pessoa;
import negocio.RepositorioPessoas;

public class RepositorioPessoasLista implements RepositorioPessoas {

	private List<Pessoa> pessoas;

	public RepositorioPessoasLista() {
		this.pessoas = new ArrayList<Pessoa>();

	}

	public void inserir(Pessoa pessoa) {
		this.pessoas.add(pessoa);

	}

	@Override
	public Pessoa procurar(String numCpf) {
		Pessoa procurada = null;
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf().equals(numCpf))
				procurada = pessoa;
		}
		return procurada;
	}

	@Override
	public void remover(String numCpf) {
		int posicao = -1;
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf().equals(numCpf))
				;
			posicao = pessoas.indexOf(pessoa);
			break;
		}

		if (posicao != -1)
			pessoas.remove(posicao);

	}

	public List<Pessoa> listarPessoas() {
		return this.pessoas;

	}	
	
	@Override
	public String toString() {
		return "\n" + pessoas;
	}

}