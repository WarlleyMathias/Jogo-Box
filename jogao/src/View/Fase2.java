package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controle.ControleFase2;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Fase2 extends JFrame {

	private JPanel contentPane;
	private final ControleFase2 controle;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fase2 frame = new Fase2();
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
	public Fase2() {
		
		controle = new ControleFase2(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(138, 134, 146, 14);
		progressBar.setStringPainted(true);
		progressBar.setValue(0);
		progressBar.setMaximum(100);
		contentPane.add(progressBar);
		
		JLabel lblRound = new JLabel("ROUND ");
		lblRound.setBounds(187, 109, 89, 14);
		contentPane.add(lblRound);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Fase2.class.getResource("/View/imagens/Boxeador.png")));
		label.setBounds(0, 0, 139, 182);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Fase2.class.getResource("/View/imagens/Oponente1.png")));
		label_1.setBounds(295, 0, 139, 182);
		contentPane.add(label_1);
		
		JLabel num = new JLabel("0");
		num.setBounds(201, 120, 30, 14);
		contentPane.add(num);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Fase2.class.getResource("/View/imagens/dadinho.gif")));
		label_2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				controle.dado(label_2);
			}
		});
		label_2.setVisible(false);
		label_2.setBounds(0, 204, 50, 57);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Fase2.class.getResource("/View/imagens/dadinho.gif")));
		label_3.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				controle.dado(label_3);
			}
		});
		label_3.setVisible(false);
		label_3.setBounds(384, 204, 50, 57);
		contentPane.add(label_3);
		
		JButton btnNewButton = new JButton("Lutar!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.lutar(progressBar, num , btnNewButton, lblRound, label_2, label_3);	
			}
		});
		btnNewButton.setBounds(166, 159, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblEstilo = new JLabel("New label");
		lblEstilo.setBounds(35, 179, 89, 14);
		contentPane.add(lblEstilo);
		
		JLabel lblEstilo2 = new JLabel("New label");
		lblEstilo2.setBounds(305, 179, 89, 14);
		contentPane.add(lblEstilo2);
		
		controle.escreveEstilo(lblEstilo, lblEstilo2);
	}
}

