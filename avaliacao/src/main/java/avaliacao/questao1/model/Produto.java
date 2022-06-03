package avaliacao.questao1.model;

import java.sql.Date;

public class Produto {

	private int id;
	private String nome, descricao;
	private String desconto;
	private String dataInicio;

	public Produto() {

	}

	public Produto(String nome, String descricao, String desconto, String dataInicio) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.desconto = desconto;
		this.dataInicio = dataInicio;
	}

	public Produto(int id, String nome, String descricao, String desconto, String dataInicio) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.desconto = desconto;
		this.dataInicio = dataInicio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDesconto() {
		return desconto;
	}

	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", desconto=" + desconto
				+ ", dataInicio=" + dataInicio + "]";
	}

}
