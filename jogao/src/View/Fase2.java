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
		progressBar.setBounds(139, 134, 146, 14);
		progressBar.setStringPainted(true);
		progressBar.setValue(0);
		progressBar.setMaximum(100);
		contentPane.add(progressBar);
	
		
		
		
		JLabel lblRound = new JLabel("ROUND");
		lblRound.setBounds(191, 109, 46, 14);
		contentPane.add(lblRound);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Warlley\\Desktop\\Boxeado.png"));
		label.setBounds(10, 11, 146, 150);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Warlley\\Desktop\\adversario.png"));
		label_1.setBounds(295, 11, 129, 150);
		contentPane.add(label_1);
		
		JButton btnNewButton = new JButton("Lutar!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				new Thread() {
					public void run() {

						while(progressBar.getValue() < 100) {
							try {
								sleep(20);
								progressBar.setValue(progressBar.getValue()+1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}.start();;
				
				controle.lutar();
				
				
			}
		});
		btnNewButton.setBounds(166, 159, 89, 23);
		contentPane.add(btnNewButton);
	
	}


	
}

