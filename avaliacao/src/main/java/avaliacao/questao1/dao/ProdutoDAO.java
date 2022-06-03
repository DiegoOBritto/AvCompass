package avaliacao.questao1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import avaliacao.questao1.model.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void cadastrar(Produto produto) throws SQLException {
		String sql = "INSERT INTO produtos (nome, descricao, desconto, data) VALUES (?,?,?,?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setString(3, produto.getDesconto());
			pstm.setString(4, produto.getDataInicio());

			pstm.execute();

			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					produto.setId(rst.getInt(1));
				}

			}
		}

	}

	public void listar() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();

		String sql = "SELECT ID, NOME, DESCRICAO, DESCONTO, DATA FROM produtos WHERE DESCRICAO LIKE ?";

		Scanner sc = new Scanner(System.in);

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {

			String busca = sc.nextLine();
			pstm.setString(1, "%" + busca + "%");
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
							rst.getString(5));

					produtos.add(produto);
				}
			}
		}

		for (Produto p : produtos) {
			System.out.println(p.getId() + "\n " + p.getNome() + "\n " + p.getDescricao() + "\n " + p.getDesconto()
					+ "\n " + p.getDataInicio());
		}
	}

	public void atualizar(String nome, String descricao, String desconto, String data, Integer id) throws SQLException {
		try (PreparedStatement stm = connection.prepareStatement(
				"UPDATE produtos P SET P.NOME = ?, P.DESCRICAO = ?, P.DESCONTO = ?, P.DATA = ? WHERE ID = ?")) {
			stm.setString(1, nome);
			stm.setString(2, descricao);
			stm.setString(3, desconto);
			stm.setString(4, data);
			stm.setInt(5, id);
			stm.execute();
		}
	}

	public void delete(Integer id) throws SQLException {
		try (PreparedStatement stm = connection.prepareStatement("DELETE FROM produtos WHERE ID = ?")) {
			stm.setInt(1, id);
			stm.execute();
		}
	
	
}
}
