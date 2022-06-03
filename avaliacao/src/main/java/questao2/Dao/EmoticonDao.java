package questao2.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import questao2.Model.Emoticon;

public class EmoticonDao {

	private Connection connection;

	public EmoticonDao(Connection connection) {
		this.connection = connection;
	}

	public void inserir(Emoticon emoticon) throws SQLException {
		String sql = "INSERT INTO tb_sentimento VALUES (?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, emoticon.getSentimento());

			pstm.execute();

			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					emoticon.setId(rst.getInt(1));
				}

			}
		}

	}
	
}
