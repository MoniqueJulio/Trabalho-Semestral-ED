package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.leandrocolevati.Lista.Lista;
import model.Consulta;
import model.Tcc;

public class ConsultaController implements ActionListener {

	private JTextArea taConsultaSolicitacoes;
	private JTextField tfConsultaOrientador;

	public ConsultaController(JTextArea taConsultaSolicitacoes, JTextField tfConsultaOrientador) {
		super();
		this.taConsultaSolicitacoes = taConsultaSolicitacoes;
		this.tfConsultaOrientador = tfConsultaOrientador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Consultar Solicitações")) {
			try {
				consultar();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	private void consultar() throws Exception {
		Tcc consultaTcc = new Tcc();
		Lista consultaLista = new Lista();
		Consulta cs = new Consulta();

		cs.orientadorConsulta = tfConsultaOrientador.getText();
		consultaLista = consulta(consultaTcc.orientador);

		if (cs.orientadorConsulta != null) {
			consultaLista = consulta(cs.orientadorConsulta);
		} else {
			JOptionPane.showMessageDialog(null, "Preencha     o campo", "ERRO", JOptionPane.ERROR_MESSAGE);
		}

		int tamanhoLista = consultaLista.size();
		StringBuffer buffer = new StringBuffer();
		if (tamanhoLista > 0) {
			for (int i = 0; i < tamanhoLista; i++) {
				Tcc tcc = (Tcc) consultaLista.get(i);
				if (tcc.integrante != "" && tcc.integrante2 == "" && tcc.integrante3 == "") {
					buffer.append("Título: " + tcc.titulo + "\nIntegrantes: " + tcc.integrante + "\nModalidade de TCC: "
							+ tcc.modalidade + "\nOrientador: " + tcc.orientador + "\nDescrição: " + tcc.descricao
							+ "\r\n\n");
				} else if (tcc.integrante != "" && tcc.integrante2 != "" && tcc.integrante3 == "") {
					buffer.append("Título: " + tcc.titulo + "\nIntegrantes: " + tcc.integrante
							+ "\n                       " + tcc.integrante2 + "\nModalidade de TCC: " + tcc.modalidade
							+ "\nOrientador: " + tcc.orientador + "\nDescrição: " + tcc.descricao + "\r\n\n");
				} else {
					buffer.append("Título: " + tcc.titulo + "\nIntegrantes: " + tcc.integrante
							+ "\n                       " + tcc.integrante2 + "\n                       "
							+ tcc.integrante3 + "\nModalidade de TCC: " + tcc.modalidade + "\nOrientador: "
							+ tcc.orientador + "\nDescrição: " + tcc.descricao + "\r\n\n");
				}
			}
			taConsultaSolicitacoes.setText(buffer.toString());
		}
		tfConsultaOrientador.setText("");
	}

	private Lista consulta(String orientador) throws IOException {
		Lista consultaLista = new Lista();
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastroTcc";
		File arquivo = new File(path, "Tcc.csv");

		if (arquivo.exists() && arquivo.isFile()) {
			FileInputStream fis = new FileInputStream(arquivo);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while (linha != null) {
				String vetLinha[] = linha.split(";");
				if (vetLinha[5].equals(orientador)) {
					Tcc consultaTcc = new Tcc();
					consultaTcc.titulo = vetLinha[0];
					consultaTcc.modalidade = vetLinha[1];
					consultaTcc.integrante = vetLinha[2];
					consultaTcc.integrante2 = vetLinha[3];
					consultaTcc.integrante3 = vetLinha[4];
					consultaTcc.orientador = vetLinha[5];
					consultaTcc.descricao = vetLinha[6];

					consultaLista.addFirst(consultaTcc);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
		return consultaLista;
	}
}
