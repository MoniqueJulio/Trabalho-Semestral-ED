package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ConsultaController;
import controller.OrientandoController;
import controller.TccController;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Tela extends JFrame {

	private static final long serialVersionUID = -8533024649811972087L;
	private JPanel contentPane;
	private JTextField tfCadastroTitulo;
	private JTextField tfCadastroIntegrantes;
	private JTextField tfCadastroOrientador;
	private JTextField tfCadastroModalidade;
	private JTextField tfCadastroDescricao;
	private JTextField tfRespostaTitulo;
	private JTextField tfRespostaAssunto;
	private JTextField tfRespostaDescricao;
	private JTextField tfRespostaResposta;
	private JTextField tfRespostaNota;
	private JTextField tfConsultaOrientador;
	private JTextField tfCadastroIntegrantes2;
	private JTextField tfCadastroIntegrantes3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tela() {
		setTitle("Sistema de Gerenciamento de TCC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 624, 430);
		contentPane.add(tabbedPane);

		JPanel tabCadastro = new JPanel();
		tabbedPane.addTab("Cadastro TCC", null, tabCadastro, "Cadastro de TCC");
		tabCadastro.setLayout(null);

		JLabel lblCadastroTitulo = new JLabel("Título");
		lblCadastroTitulo.setBounds(29, 47, 45, 25);
		lblCadastroTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabCadastro.add(lblCadastroTitulo);

		JLabel lblCadastroIntegrante = new JLabel("Integrantes");
		lblCadastroIntegrante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastroIntegrante.setBounds(29, 94, 85, 25);
		tabCadastro.add(lblCadastroIntegrante);

		JLabel lblCadastroOrientador = new JLabel("Orientador");
		lblCadastroOrientador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastroOrientador.setBounds(29, 217, 85, 25);
		tabCadastro.add(lblCadastroOrientador);

		JLabel lblCadastroDescricao = new JLabel("Descrição");
		lblCadastroDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastroDescricao.setBounds(29, 273, 85, 25);
		tabCadastro.add(lblCadastroDescricao);

		JLabel lblCadastroModalidade = new JLabel("Modalidade de TCC");
		lblCadastroModalidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastroModalidade.setBounds(342, 90, 133, 33);
		tabCadastro.add(lblCadastroModalidade);

		tfCadastroTitulo = new JTextField();
		tfCadastroTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCadastroTitulo.setBounds(110, 49, 365, 25);
		tabCadastro.add(tfCadastroTitulo);
		tfCadastroTitulo.setColumns(10);

		tfCadastroIntegrantes = new JTextField();
		tfCadastroIntegrantes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCadastroIntegrantes.setBounds(110, 96, 212, 25);
		tabCadastro.add(tfCadastroIntegrantes);
		tfCadastroIntegrantes.setColumns(10);
		
		tfCadastroIntegrantes2 = new JTextField();
		tfCadastroIntegrantes2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCadastroIntegrantes2.setBounds(110, 127, 212, 25);
		tabCadastro.add(tfCadastroIntegrantes2);
		tfCadastroIntegrantes2.setColumns(10);
		
		tfCadastroIntegrantes3 = new JTextField();
		tfCadastroIntegrantes3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCadastroIntegrantes3.setBounds(110, 158, 212, 25);
		tabCadastro.add(tfCadastroIntegrantes3);
		tfCadastroIntegrantes3.setColumns(10);

		tfCadastroOrientador = new JTextField();
		tfCadastroOrientador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCadastroOrientador.setBounds(110, 219, 212, 25);
		tabCadastro.add(tfCadastroOrientador);
		tfCadastroOrientador.setColumns(10);

		tfCadastroModalidade = new JTextField();
		tfCadastroModalidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCadastroModalidade.setBounds(470, 96, 103, 25);
		tabCadastro.add(tfCadastroModalidade);
		tfCadastroModalidade.setColumns(10);

		JButton btnCadastroConcluir = new JButton("Concluir");
		btnCadastroConcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastroConcluir.setBounds(470, 338, 103, 42);
		tabCadastro.add(btnCadastroConcluir);

		tfCadastroDescricao = new JTextField();
		tfCadastroDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCadastroDescricao.setBounds(106, 272, 341, 108);
		tabCadastro.add(tfCadastroDescricao);
		tfCadastroDescricao.setColumns(10);

		TccController tcc = new TccController(tfCadastroTitulo, tfCadastroModalidade, tfCadastroIntegrantes, tfCadastroIntegrantes2, tfCadastroIntegrantes3, tfCadastroOrientador, tfCadastroDescricao);
					
		JPanel tabResposta = new JPanel();
		tabbedPane.addTab("Resposta Orientando", null, tabResposta, "Resposta ao Orientando");
		tabResposta.setLayout(null);
		
		JLabel lblRespostaTítulo = new JLabel("Título");
		lblRespostaTítulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRespostaTítulo.setBounds(25, 49, 46, 14);
		tabResposta.add(lblRespostaTítulo);
		
		JLabel lblRespostaAssunto = new JLabel("Assunto");
		lblRespostaAssunto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRespostaAssunto.setBounds(25, 99, 60, 17);
		tabResposta.add(lblRespostaAssunto);
		
		JLabel lblRespostaDescricao = new JLabel("Descrição");
		lblRespostaDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRespostaDescricao.setBounds(25, 142, 72, 17);
		tabResposta.add(lblRespostaDescricao);
		
		JLabel lblRespostaResposta = new JLabel("Resposta");
		lblRespostaResposta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRespostaResposta.setBounds(25, 224, 72, 17);
		tabResposta.add(lblRespostaResposta);
		
		JLabel lblRespostaNota = new JLabel("Atribuir nota");
		lblRespostaNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRespostaNota.setBounds(25, 313, 85, 25);
		tabResposta.add(lblRespostaNota);
		
		tfRespostaTitulo = new JTextField();
		tfRespostaTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfRespostaTitulo.setBounds(104, 49, 423, 25);
		tabResposta.add(tfRespostaTitulo);
		tfRespostaTitulo.setColumns(10);
		
		tfRespostaAssunto = new JTextField();
		tfRespostaAssunto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfRespostaAssunto.setBounds(104, 95, 276, 25);
		tabResposta.add(tfRespostaAssunto);
		tfRespostaAssunto.setColumns(10);
		
		tfRespostaDescricao = new JTextField();
		tfRespostaDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfRespostaDescricao.setBounds(104, 143, 353, 59);
		tabResposta.add(tfRespostaDescricao);
		tfRespostaDescricao.setColumns(10);
		
		tfRespostaResposta = new JTextField();
		tfRespostaResposta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfRespostaResposta.setBounds(104, 224, 353, 70);
		tabResposta.add(tfRespostaResposta);
		tfRespostaResposta.setColumns(10);
		
		tfRespostaNota = new JTextField();
		tfRespostaNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfRespostaNota.setBounds(104, 315, 72, 25);
		tabResposta.add(tfRespostaNota);
		tfRespostaNota.setColumns(10);
		
		JButton btnRespostaEnviar = new JButton("Enviar");
		btnRespostaEnviar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRespostaEnviar.setBounds(232, 345, 148, 33);
		tabResposta.add(btnRespostaEnviar);
		btnCadastroConcluir.addActionListener(tcc);
		
		OrientandoController orientando = new OrientandoController(tfRespostaTitulo, tfRespostaAssunto, tfRespostaDescricao, tfRespostaResposta, tfRespostaNota);
		
		JPanel TabConsulta = new JPanel();
		tabbedPane.addTab("Consulta Solicitações", null, TabConsulta, "Consulta de solicitações de TCC");
		TabConsulta.setLayout(null);
		
		JLabel lblConsultaSolicitacoes = new JLabel("Solicitações em Andamento");
		lblConsultaSolicitacoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsultaSolicitacoes.setBounds(41, 95, 176, 25);
		TabConsulta.add(lblConsultaSolicitacoes);
		
		JButton btnConsultaConsultarSolicitacoes = new JButton("Consultar Solicitações");
		btnConsultaConsultarSolicitacoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultaConsultarSolicitacoes.setBounds(41, 351, 187, 40);
		TabConsulta.add(btnConsultaConsultarSolicitacoes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(41, 131, 537, 198);
		TabConsulta.add(scrollPane);
		JTextArea taConsultaSolicitacoes = new JTextArea();
		scrollPane.setViewportView(taConsultaSolicitacoes);		
		

		tfConsultaOrientador = new JTextField();
		tfConsultaOrientador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfConsultaOrientador.setBounds(41, 57, 271, 23);
		tfConsultaOrientador.setColumns(10);		
		
		ConsultaController consulta = new ConsultaController(taConsultaSolicitacoes, tfConsultaOrientador);

		TabConsulta.add(tfConsultaOrientador);

		btnRespostaEnviar.addActionListener(orientando);		
		
		JLabel lblConsultaOrientador = new JLabel("Consulta por Orientador:");
		lblConsultaOrientador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsultaOrientador.setBounds(41, 21, 164, 25);
		TabConsulta.add(lblConsultaOrientador);
		btnConsultaConsultarSolicitacoes.addActionListener(consulta);

	}
}
