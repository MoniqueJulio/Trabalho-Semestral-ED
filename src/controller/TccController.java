package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Tcc;

public class TccController implements ActionListener {

	private JTextField tfCadastroTitulo;
	private JTextField tfCadastroModalidade;
	private JTextField tfCadastroIntegrantes;
	private JTextField tfCadastroIntegrantes2;
	private JTextField tfCadastroIntegrantes3;
	private JTextField tfCadastroOrientador;
	private JTextField tfCadastroDescricao;


	public TccController(JTextField tfCadastroTitulo, JTextField tfCadastroModalidade, JTextField tfCadastroIntegrantes,
			JTextField tfCadastroIntegrantes2, JTextField tfCadastroIntegrantes3, JTextField tfCadastroOrientador,
			JTextField tfCadastroDescricao) {
		super();
		this.tfCadastroTitulo = tfCadastroTitulo;
		this.tfCadastroModalidade = tfCadastroModalidade;
		this.tfCadastroIntegrantes = tfCadastroIntegrantes;
		this.tfCadastroIntegrantes2 = tfCadastroIntegrantes2;
		this.tfCadastroIntegrantes3 = tfCadastroIntegrantes3;
		this.tfCadastroOrientador = tfCadastroOrientador;
		this.tfCadastroDescricao = tfCadastroDescricao;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Concluir")) {
			try {
				concluir();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	private void concluir() throws IOException {
		Tcc tcc = new Tcc();

		tcc.titulo = tfCadastroTitulo.getText();
		tcc.modalidade = tfCadastroModalidade.getText();
		tcc.integrante = tfCadastroIntegrantes.getText();
		tcc.integrante2 = tfCadastroIntegrantes2.getText();
		tcc.integrante3 = tfCadastroIntegrantes3.getText();
		tcc.orientador = tfCadastroOrientador.getText();
		tcc.descricao = tfCadastroDescricao.getText();		

		cadastraTcc(tcc.toString());
		tfCadastroTitulo.setText("");
		tfCadastroModalidade.setText("");
		tfCadastroIntegrantes.setText("");
		tfCadastroIntegrantes2.setText("");
		tfCadastroIntegrantes3.setText("");
		tfCadastroOrientador.setText("");
		tfCadastroDescricao.setText("");
	}

	private void cadastraTcc(String csvTcc) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastroTcc";
		File diretorio = new File(path);
		if (!diretorio.exists()) {
			diretorio.mkdir();
		}

		File arquivo = new File(path, "Tcc.csv");
		boolean existe = false;
		if (arquivo.exists()) {
			existe = true;
		}

		FileWriter fw = new FileWriter(arquivo, existe);
		PrintWriter print = new PrintWriter(fw);
		print.write(csvTcc + "\r\n");
		print.flush();
		print.close();
		fw.close();

	}

}