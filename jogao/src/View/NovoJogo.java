package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controle.NJControle;
import Model.DAO.Banco;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class NovoJogo extends JFrame {

	private final NJControle controle;
	private JPanel contentPane;
	private JTextField textNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoJogo frame = new NovoJogo();
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
	public NovoJogo() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Warlley\\Desktop\\Boxeado.png"));
		label.setBounds(268, 11, 156, 205);
		contentPane.add(label);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(10, 77, 46, 14);
		contentPane.add(lblIdade);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(18, 18, 70, 1));
		spinner.setBounds(58, 74, 46, 20);
		contentPane.add(spinner);

		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(20, 20, 30, 1));
		spinner_1.setBounds(58, 99, 46, 20);
		contentPane.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(40, 40, 150, 1));
		spinner_2.setBounds(58, 124, 46, 20);
		contentPane.add(spinner_2);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 127, 30, 14);
		contentPane.add(lblPeso);
		
		JLabel lblFora = new JLabel("For\u00E7a:");
		lblFora.setBounds(10, 102, 46, 14);
		contentPane.add(lblFora);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setBounds(10, 36, 38, 14);
		contentPane.add(lblPas);
		
		textNome = new JTextField();
		textNome.setBounds(48, 8, 86, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblTecnica = new JLabel("Tecnica:");
		lblTecnica.setBounds(10, 155, 46, 14);
		contentPane.add(lblTecnica);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner_3.setBounds(58, 152, 46, 20);
		contentPane.add(spinner_3);
		
		JComboBox boxPais = new JComboBox();
		boxPais.setModel(new DefaultComboBoxModel(new String[] {"Brasil", "EUA", "Argentina"}));
		boxPais.setBounds(48, 36, 86, 22);
		
		contentPane.add(boxPais);
		
		JButton btnJogar = new JButton("Jogar");
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.abrirFase1(boxPais, spinner, spinner_1, spinner_2, spinner_3);
				
				
				
			}
		});
		btnJogar.setBounds(335, 227, 89, 23);
		contentPane.add(btnJogar);
		
		
		
		
		controle = new NJControle(this);	
		Banco.inicia();
	}
	

	public JTextField getTextNome() {
		return textNome;
	}

	public void setTextNome(JTextField textField) {
		this.textNome = textField;
	}
}
