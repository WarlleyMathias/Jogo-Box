package View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controle.FaseControle;

import Model.Data;
import Model.Lutador;
import Model.DAO.ContadorDAO;
import Model.DAO.DataDAO;
import Model.DAO.LutadorDAO;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class Fase1 extends JFrame {

	private final FaseControle controle;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {        

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fase1 frame = new Fase1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fase1() {
		
		controle                = new FaseControle(this);
		LutadorDAO lutadorDAO   = new LutadorDAO();
		DataDAO dataDAO         = new DataDAO();
		Lutador lutador         = lutadorDAO.getLutador();
		Lutador Oponente        = lutadorDAO.getOponente();
		Data data               = dataDAO.getData();
		ContadorDAO contadorDAO = new ContadorDAO();
		contadorDAO.getContador3().setA(Oponente.getId());
		
		this.setEnabled(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize( 450, 300);
		this.setLocationRelativeTo(null);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		
		JButton proximaLuta = new JButton("proxima luta");
		
		JInternalFrame janelaPatrocinio = new JInternalFrame("Patrocinio");
		janelaPatrocinio.setBorder(null);
		janelaPatrocinio.setBounds(0, 22, 434, 239);
		contentPane.add(janelaPatrocinio);
		janelaPatrocinio.getContentPane().setLayout(null);
		janelaPatrocinio.setVisible(false);
		
		
		JButton btnVoltar_1 = new JButton("voltar");
		btnVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.patrocinioClose(janelaPatrocinio);
			}
		});
		btnVoltar_1.setBounds(10, 11, 89, 23);
		janelaPatrocinio.getContentPane().add(btnVoltar_1);
		
		JInternalFrame janelaTreino = new JInternalFrame("Treino");
		janelaTreino.setBorder(null);
		janelaTreino.setEnabled(false);
		janelaTreino.setBounds(0, 22, 434, 239);
		contentPane.add(janelaTreino);
		janelaTreino.getContentPane().setLayout(null);
		janelaTreino.setVisible(false);
		
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.treinoClose(janelaTreino);
			}
		});
		btnVoltar.setBounds(10, 178, 89, 23);
		janelaTreino.getContentPane().add(btnVoltar);
			
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 22);
		contentPane.add(menuBar);
		
		JButton btnTreino = new JButton("treino");
		btnTreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.treino(janelaTreino);
				controle.patrocinioClose(janelaPatrocinio);
			}
		});
		menuBar.add(btnTreino);
		
		JButton btnPatrocinio = new JButton("patrocinio");
		btnPatrocinio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.patrocinio(janelaPatrocinio);
				controle.treinoClose(janelaTreino);
			}
		});
		menuBar.add(btnPatrocinio);
		
		JInternalFrame preLuta = new JInternalFrame("New JInternalFrame");
		preLuta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		preLuta.setBounds(188, 22, 246, 239);
		contentPane.add(preLuta);
		preLuta.getContentPane().setLayout(null);
		preLuta.setVisible(false);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 143, 90, 27);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Defensivo", "Ofensivo", "Equilibrado"}));
		comboBox.setToolTipText("");
		preLuta.getContentPane().add(comboBox);
		
		JButton btnVoltar_2 = new JButton("voltar");
		btnVoltar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.preLuta2(preLuta);
				controle.destravarBotao(btnPatrocinio);
				controle.destravarBotao2(btnTreino);
				controle.proxluta(proximaLuta);
			}
		});
		btnVoltar_2.setBounds(10, 11, 89, 23);
		preLuta.getContentPane().add(btnVoltar_2);
		
		JLabel lblEstilo = new JLabel("Estilo de Luta");
		lblEstilo.setBounds(10, 118, 90, 14);
		preLuta.getContentPane().add(lblEstilo);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(131, 11, 89, 96);
		label_1.setIcon(new ImageIcon(Fase1.class.getResource("/View/imagens/Oponente1.png")));
		preLuta.getContentPane().add(label_1);
		
		JLabel lblNome2 = new JLabel("Nome: ");
		lblNome2.setBounds(141, 118, 101, 14);
		lblNome2.setText(lblNome2.getText() + Oponente.getNome());
		preLuta.getContentPane().add(lblNome2);
		
		JLabel lblPais2 = new JLabel("Pa\u00EDs: ");
		lblPais2.setBounds(141, 134, 101, 14);
		lblPais2.setText(lblPais2.getText() + Oponente.getPais());
		preLuta.getContentPane().add(lblPais2);
		
		JLabel lblidade2 = new JLabel("Idade: ");
		lblidade2.setBounds(141, 149, 101, 14);
		lblidade2.setText(lblidade2.getText() + Oponente.getIdade());
		preLuta.getContentPane().add(lblidade2);
		
		JLabel lblForca2 = new JLabel("For\u00E7a: ");
		lblForca2.setBounds(141, 163, 101, 14);
		lblForca2.setText(lblForca2.getText() + Oponente.getForca());
		preLuta.getContentPane().add(lblForca2);
		
		JLabel lblResistencia2 = new JLabel("Resistencia: ");
		lblResistencia2.setBounds(141, 179, 101, 14);
		lblResistencia2.setText(lblResistencia2.getText() + Oponente.getResistencia());
		preLuta.getContentPane().add(lblResistencia2);
		
		JLabel lblTecnica2 = new JLabel("Tecnica: ");
		lblTecnica2.setBounds(141, 194, 79, 14);
		lblTecnica2.setText(lblTecnica2.getText() + Oponente.getTecnica());
		preLuta.getContentPane().add(lblTecnica2);
		
		proximaLuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				controle.preLuta(preLuta);
				controle.travarBotao(btnPatrocinio);
				controle.travarBotao2(btnTreino);
				controle.proxluta2(proximaLuta);
			}
		});
		proximaLuta.setBounds(203, 197, 154, 53);
		contentPane.add(proximaLuta);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(250, 80, 107, 14);
		lblNome.setText(lblNome.getText()+lutador.getNome());
		contentPane.add(lblNome);
		
		JLabel lblPais = new JLabel("Pa\u00EDs: ");
		lblPais.setBounds(250, 100, 107, 14);
		lblPais.setText(lblPais.getText()+lutador.getPais());
		contentPane.add(lblPais);
		
		JLabel lblidade = new JLabel("Idade: ");
		lblidade.setBounds(250, 120, 107, 14);
		lblidade.setText(lblidade.getText()+lutador.getIdade());
		contentPane.add(lblidade);
		
		JLabel lblForca = new JLabel("Forca: ");
		lblForca.setBounds(250, 140, 107, 14);
		lblForca.setText(lblForca.getText()+lutador.getForca());
		contentPane.add(lblForca);
		
		JLabel lblResistencia = new JLabel("Resistencia: ");
		lblResistencia.setBounds(250, 160, 107, 14);
		lblResistencia.setText(lblResistencia.getText()+lutador.getResistencia());
		contentPane.add(lblResistencia);
		
		JLabel lblTecnica = new JLabel("Tecnica: ");
		lblTecnica.setBounds(250, 180, 107, 14);
		lblTecnica.setText(lblTecnica.getText()+lutador.getTecnica());
		contentPane.add(lblTecnica);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Fase1.class.getResource("/View/imagens/Boxeador.png")));
		label.setBounds(10, 33, 154, 201);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel(data.getDd()+"/"+data.getMm()+"/"+data.getAa());
		lblNewLabel.setBounds(316, 22, 118, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(10, 90, 163, 14);
		janelaTreino.getContentPane().add(label_2);
		
		JButton btnTreinoDeFora = new JButton("Treino de For\u00E7a");
		JButton btnTreinarTecnica = new JButton("Treinar Tecnica");
		btnTreinarTecnica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			controle.treinarTecnica(label_2, btnTreinoDeFora, btnTreinarTecnica);
			}
		});
		btnTreinarTecnica.setBounds(219, 11, 163, 44);
		janelaTreino.getContentPane().add(btnTreinarTecnica);
		
		//O bntTreinoDeForca, está instanciado acima! 
		btnTreinoDeFora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.treinarForca(label_2, btnTreinoDeFora, btnTreinarTecnica);
			}
		});
		btnTreinoDeFora.setBounds(10, 11, 163, 44);
		janelaTreino.getContentPane().add(btnTreinoDeFora);
	
		JButton btnLuta = new JButton("Luta!");
		btnLuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.abrirFase2(lblNewLabel);
				controle.getEstilo(comboBox);
			}
		});
		btnLuta.setBounds(10, 175, 89, 35);
		preLuta.getContentPane().add(btnLuta);
		
		controle.faltam(contadorDAO, label_2);
		controle.contador2(lutador, contadorDAO, lblTecnica, btnTreinoDeFora, btnTreinarTecnica);
		controle.contador1(lutador, contadorDAO, lblForca, btnTreinoDeFora, btnTreinarTecnica);		
		controle.enabledBtn(contadorDAO, btnTreinarTecnica, btnTreinoDeFora);
	}
}
