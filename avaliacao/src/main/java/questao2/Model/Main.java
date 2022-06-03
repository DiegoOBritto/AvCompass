package questao2.Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import questao2.Dao.EmoticonDao;
import questao2.Factory.ConnectionFactory;

public class Main {

	public static void main(String[] args) throws Exception {

		new ConnectionFactory();
		try (Connection connection = new ConnectionFactory().createConnectionToMySQL()){
			EmoticonDao emoticonDao = new EmoticonDao(connection);

			Emoticon emoticon = new Emoticon();
			Scanner sc = new Scanner(System.in);

			String resposta = sc.next();
			int contFeliz = 0;
			int contTriste = 0;

			if (resposta.contains(":-)")) {

				Matcher matcher = Pattern.compile("[:]+[-]+[)]").matcher(resposta);
				while (matcher.find()) {
					contFeliz++;
					System.out.println(matcher.group());
				}
				System.out.println(contFeliz);
			} else if (resposta.contains(":-("))
				;

			Matcher matcher = Pattern.compile("[:]+[-]+[(]").matcher(resposta);
			while (matcher.find()) {
				contTriste++;
				System.out.println(matcher.group());
			}
			System.out.println(contTriste);

			if (contFeliz == contTriste) {
				emoticon.setSentimento("neutro");
				System.out.println("neutro");
			} else if (contFeliz > contTriste) {
				emoticon.setSentimento("divertido");
				System.out.println("divertido");
			} else {
				emoticon.setSentimento("chateado");
				System.out.println("chateado");
			}
			emoticonDao.inserir(emoticon);
		}
	}

}
