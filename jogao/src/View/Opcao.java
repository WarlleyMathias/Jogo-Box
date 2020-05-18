package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controle.OpcaoControle;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Opcao extends JFrame {

	private JPanel contentPane;
	private final OpcaoControle controle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Opcao frame = new Opcao();
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
	public Opcao() {
		controle = new OpcaoControle(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVolume = new JLabel("volume");
		lblVolume.setBounds(190, 54, 46, 14);
		contentPane.add(lblVolume);
		
		JSlider slider = new JSlider();
		slider.setBounds(106, 79, 200, 26);
		contentPane.add(slider);
		
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.voltar();
				
			}
		});
		btnVoltar.setBounds(164, 139, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Warlley\\Desktop\\opcao box - Copia (2).jpg"));
		label.setBounds(0, 0, 444, 271);
		contentPane.add(label);
	}
}
