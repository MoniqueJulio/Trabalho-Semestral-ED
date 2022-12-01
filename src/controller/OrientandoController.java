package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JTextField;

import model.Orientando;

public class OrientandoController implements ActionListener {

	private JTextField tfRespostaTitulo;
	private JTextField tfRespostaAssunto;
	private JTextField tfRespostaDescricao;
	private JTextField tfRespostaResposta;
	private JTextField tfRespostaNota;

	public OrientandoController(JTextField tfRespostaTitulo, JTextField tfRespostaAssunto,
			JTextField tfRespostaDescricao, JTextField tfRespostaResposta, JTextField tfRespostaNota) {
		this.tfRespostaTitulo = tfRespostaTitulo;
		this.tfRespostaAssunto = tfRespostaAssunto;
		this.tfRespostaDescricao = tfRespostaDescricao;
		this.tfRespostaResposta = tfRespostaResposta;
		this.tfRespostaNota = tfRespostaNota;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Enviar")) {

			try {
				enviar();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void enviar() throws IOException {
		Orientando orientando = new Orientando();

		orientando.titulo = tfRespostaTitulo.getText();
		orientando.assunto = tfRespostaAssunto.getText();
		orientando.descricao = tfRespostaDescricao.getText();
		orientando.resposta = tfRespostaResposta.getText();
		orientando.nota = tfRespostaNota.getText();
		
		cadastraOrientando(orientando.toString());

		tfRespostaTitulo.setText("");
		tfRespostaAssunto.setText("");
		tfRespostaDescricao.setText("");
		tfRespostaResposta.setText("");
		tfRespostaNota.setText("");

	}

	private void cadastraOrientando(String csvOrientando) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastroTcc";
		File diretorio = new File(path);
		if (!diretorio.exists()) {
			diretorio.mkdir();
		}
		File arquivo = new File(path, "RespostaOrientando.csv");
		boolean existe = false;
		if (arquivo.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arquivo, existe);
		PrintWriter print = new PrintWriter(fw);
		print.write(csvOrientando + "\r\n");
		print.flush();
		print.close();
		fw.close();

	}

}
