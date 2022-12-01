package model;

public class Orientando {

	public String titulo;
	public String assunto;
	public String descricao;
	public String resposta;
	public String nota;

	@Override
	public String toString() {
		return titulo + ";" + assunto + ";" + descricao + ";" + resposta + ";" + nota;
	}

}
