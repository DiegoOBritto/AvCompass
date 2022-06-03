package avaliacao.questao1.teste;

import java.sql.Connection;
import java.util.Scanner;

import avaliacao.questao1.dao.ProdutoDAO;
import avaliacao.questao1.model.Produto;
import avaliacao.questao1Factory.ConnectionFactory;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		Produto produto = new Produto();

		try (Connection connection = new ConnectionFactory().createConnectionToMySQL()) {
			ProdutoDAO produtoDao = new ProdutoDAO(connection);

			System.out.println("Bem vindo(a)!");
			System.out.println("Digite uma opção:");
			System.out.println("1 - para Cadastrar uma nova oferta");
			System.out.println("2 - para Atualizar uma oferta");
			System.out.println("3 - para Deletar uma oferta");
			System.out.println("4 - para Buscar item por palavra");
			System.out.println("5 - para Sair");

			int entrada = sc.nextInt();
			int i;
			if (entrada == 1) {

				System.out.println("Cadastre os produtos.!");

				for (i = 0; i < 3; i++) {

					System.out.println("Digite o nome do produto: ");
					produto.setNome(sc.next());
					System.out.println("Digite a descrição do produto: ");
					produto.setDescricao(sc.next());
					System.out.println("Digite o valor do desconto: ");
					produto.setDesconto(sc.next());
					System.out.println("Digite a data de inicio(ano-mes-dia)");
					produto.setDataInicio(sc.next());
					System.out.println("Nome: " + produto.getNome() + "\nDescrição: " + produto.getDescricao()
							+ "\nDesconto: " + produto.getDesconto() + "\nData: " + produto.getDataInicio());
				}

				produtoDao.cadastrar(produto);

			} else if (entrada == 2) {
				System.out.println("Digite o ID do produto que deseja atualizar: ");

			} else if (entrada == 3) {
				System.out.println("Digite o ID do produto que deseja excluir: ");
				produtoDao.delete(sc.nextInt());

			} else if (entrada == 4) {
				System.out.println("Digite palavra chave para buscar os produtos: ");
				produtoDao.listar();

			} else if (entrada == 5) {
				System.out.println("fim!");

			}

		}

	}

}
