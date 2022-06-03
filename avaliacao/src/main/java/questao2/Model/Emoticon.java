package questao2.Model;

public class Emoticon {

	private int id;
	private String sentimento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSentimento() {
		return sentimento;
	}

	public void setSentimento(String sentimento) {
		this.sentimento = sentimento;
	}

	@Override
	public String toString() {
		return "Emoticon [id=" + id + ", sentimento=" + sentimento + "]";
	}
}
