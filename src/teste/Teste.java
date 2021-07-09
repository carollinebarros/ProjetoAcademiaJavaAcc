package teste;

import java.util.Scanner;

import dados.RepositorioPessoasArray;
import negocio.Aluno;
import negocio.Curso;
import negocio.InserirException;
import negocio.Pessoa;
import negocio.Professor;
import negocio.RepositorioPessoas;


public class Teste {

	public static void main(String[] args) {
		
		
		Scanner ler = new Scanner(System.in);

		// RepositorioPessoas rep = new RepositorioPessoasLista();

		System.out.println("Digite o tamanho do seu vetor: ");
		int tamanhoArray = ler.nextInt();
		RepositorioPessoas rep = new RepositorioPessoasArray(tamanhoArray);

		int resposta = 2;
		while (resposta != 0) {
			System.out.println("\n");
			System.out.println("+-------------------------------------------+");
			System.out.println("|              MENU DE OPÇÕES:              |");
			System.out.println("+-------------------------------------------+");
			System.out.println("|      1 - Cadastrar Aluno e Curso          |");
			System.out.println("|      2 - Cadastrar Professor              |");
			System.out.println("|      3 - Buscar                           |");
			System.out.println("|      4 - Listar pessoas cadastradas       |");
			System.out.println("|      5 - Remover                          |");
			System.out.println("|      0 - Sair                             |");
			System.out.println("+-------------------------------------------+");
			System.out.println("\nFavor digite uma opção:");
			resposta = ler.nextInt();
			if (resposta < 0 || resposta > 5) {
				System.out.println("+++++ FAVOR DIGITAR OPÇÃO VÁLIDA!!! +++++");
			}
			switch (resposta) {
			case 1:
				System.out.println("+-------------------------------------------+");
				System.out.println("|           Cadastrar Aluno e Curso:        |");
				System.out.println("+-------------------------------------------+");
				System.out.println("Favor digite o nome do aluno: ");
				String nome = ler.next();
				System.out.println("Favor digite o CPF: ");
				String cpf = ler.next();
				System.out.println("Favor digite a idade: ");
				int idade = ler.nextInt();
				System.out.println("Digite o nome do curso: ");
				String nomeCurso = ler.next();
				System.out.println("Digite o código do curso: ");
				double codigo = ler.nextDouble();
				Curso curso = new Curso(codigo, nomeCurso);
				Aluno aluno = new Aluno(nome, cpf, idade, curso);
				try {
					rep.inserir(aluno);
				} catch (InserirException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("+-------------------------------------------+");
				System.out.println("|            Cadastrar Professor:           |");
				System.out.println("+-------------------------------------------+");
				System.out.println("Favor digite o nome do professor: ");
				String nome1 = ler.next();
				System.out.println("Favor digite o CPF: ");
				String cpf1 = ler.next();
				System.out.println("Favor digite a idade: ");
				int idade1 = ler.nextInt();
				System.out.println("Digite o salário: ");
				double salario = ler.nextDouble();
				Professor professor = new Professor(nome1, cpf1, idade1, salario);
				try {
					rep.inserir(professor);
				} catch (InserirException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("+-------------------------------------------+");
				System.out.println("|                 Buscar CPF:               |");
				System.out.println("+-------------------------------------------+");
				System.out.println("Favor digite o CPF: ");
				String cpfProcurado = ler.next();
				Pessoa encontrada = rep.procurar(cpfProcurado);
				System.out.println("CADASTRO ENCONTRADO: \n" + encontrada);
				break;
			case 4:
				System.out.println("+-------------------------------------------+");
				System.out.println("|             Lista de cadastro:            |");
				System.out.println("+-------------------------------------------+");
				System.out.println(rep.toString());
				break;
			case 5:
				System.out.println("+-------------------------------------------+");
				System.out.println("|              Remover cadastro:            |");
				System.out.println("+-------------------------------------------+");
				System.out.println("Favor digite o CPF da pessoa que deseja remover do cadastro: ");
				String cpfProcurado1 = ler.next();
				Pessoa encontrada1 = rep.procurar(cpfProcurado1);
				rep.remover(cpfProcurado1);
				System.out.println("CADASTRO REMOVIDO: \n" + encontrada1);
				break;
			case 0:
				System.out.println("+-------------------------------------------+");
				System.out.println("|          PROGRAMA FINALIZADO!!!           |");
				System.out.println("+-------------------------------------------+");
				break;
			}

		}

		ler.close(); 
	}
}


