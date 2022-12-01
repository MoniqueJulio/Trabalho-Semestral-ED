package model;

public class Tcc {

	public String titulo;
	public String modalidade;
	public String integrante;
	public String integrante2;
	public String integrante3;
	public String orientador;
	public String descricao;

	@Override
	public String toString() {
		return titulo + ";" + modalidade + ";" + integrante + ";" + integrante2 + ";" + integrante3 + ";" + orientador
				+ ";" + descricao;
	}

}
