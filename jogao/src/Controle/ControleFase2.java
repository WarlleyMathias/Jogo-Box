package Controle;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import Model.Lutador;
import Model.DAO.ContadorDAO;
import Model.DAO.LutadorDAO;
import View.Fase1;
import View.Fase2;

public class ControleFase2 {
	ContadorDAO contadorDAO = new ContadorDAO();
	LutadorDAO lutadorDAO = new LutadorDAO();
	Lutador lutador = lutadorDAO.getLutador();
	Lutador Oponente = lutadorDAO.getOponenteID(contadorDAO.getContador3().getA());
	Random gerador = new Random();
	int sorte = 0;
	
	private final Fase2 view;
	
	public ControleFase2(Fase2 view) {
		this.view = view;
	}
	/**
	 * pega o valor do dado e guarda no banco de dados
	 * @param label_2
	 */
	public void dado(JLabel lbl) {
		int a = gerador.nextInt(6);
		switch(a) {
		case 0:
			lbl.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dado1.png"));	
			contadorDAO.getdado().setA(1);
			break;
		case 1:
			lbl.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dado2.png"));	
			contadorDAO.getdado().setA(2);
			break;
		case 2:
			lbl.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dado3.png"));	
			contadorDAO.getdado().setA(3);
			break;
		case 3:
			lbl.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dado4.png"));	
			contadorDAO.getdado().setA(4);
			break;
		case 4:
			lbl.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dado5.png"));	
			contadorDAO.getdado().setA(5);
			break;
		case 5:
			lbl.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dado6.png"));	
			contadorDAO.getdado().setA(6);
			break;
		}

	}
	/**
	 * Escreve na tela o estilo de luta de cada lutador, Gera um estillo de luta para o oponente
	 * @param lblEstilo
	 * @param lblEstilo2
	 */
	public void escreveEstilo(JLabel lblEstilo, JLabel lblEstilo2) {
		switch(contadorDAO.getEstilo().getA()) {
		case 1:
			lblEstilo.setText("Ofensivo");
			break;
		case 2:
			lblEstilo.setText("Defensivo");
			break;
		case 3:
			lblEstilo.setText("Equilibrado");
			break;
		}

		int Estilo = 1;
		Estilo = Estilo + gerador.nextInt(3);
		switch(Estilo){
			case 1:
				lblEstilo2.setText("Ofensivo");
				if(contadorDAO.getEstilo().getA()==1) {	
					sorte = 0;
				}
				else if(contadorDAO.getEstilo().getA()==2) {	
					sorte = 1;
				}
				else if(contadorDAO.getEstilo().getA()==3) {
					sorte = -1;
				}
				break;
			case 2:
				lblEstilo2.setText("Defensivo");
				if(contadorDAO.getEstilo().getA()==1) {	
					sorte = -1;
				}
				else if(contadorDAO.getEstilo().getA()==2) {	
					sorte = 0;
				}
				else if(contadorDAO.getEstilo().getA()==3) {	
					sorte = 1;
				}
				break;
			case 3:
				lblEstilo2.setText("Equilibrado");
				if(contadorDAO.getEstilo().getA()==1) {	
					sorte = 1;
				}
				else if(contadorDAO.getEstilo().getA()==2) {	
					sorte = -1;
				}
				else if(contadorDAO.getEstilo().getA()==3) {	
					sorte = 0;
				}
				break;
		}
		
	}
	/**
	 * Faz toda a ação da luta
	 * @param progressBar
	 * @param num
	 * @param btnNewButton
	 * @param lblRound
	 * @param label_2
	 */
	public void lutar(JProgressBar progressBar, JLabel num, JButton btnNewButton, JLabel lblRound, JLabel label_2, JLabel label_3) {
		new Thread() {
			public void run() {
							
				if(lblRound.getText()=="VITORIA" || lblRound.getText()=="DERROTA") {
					view.dispose();
					Fase1.main(null);
				}
				if(progressBar.getValue() == 100) {
					progressBar.setValue(0);
				}
				if(progressBar.getValue() == 0) {
					int nu = Integer.parseInt(num.getText()); nu++;	
					if(nu<=13) {
						if (nu<13) {
							num.setText(Integer.toString(nu));
						}
						else {
							view.dispose();
							Fase1.main(null);
						}
						while(progressBar.getValue() < 100) {
							try {
								sleep(20);		
								
								if(gerador.nextInt(20)==4) {
									
		//lutador mais forte q a resistencia do oponente
									if(lutador.getForca() > Oponente.getResistencia()) {
										
	           //Oponente mais forte q a resistencia do lutador
										if(Oponente.getForca() > lutador.getResistencia() && gerador.nextInt(10)==2) {
											
								//desempate por tecnica, pra ver quem tem chance de nocautear pimeiro
											if(Oponente.getTecnica() > lutador.getTecnica()) {
												
								/* 70% de chance de tomar nocaute*/
												if(gerador.nextInt(10) > 2) {
													lblRound.setText("Nocaute");
													label_2.setVisible(true);
													while(contadorDAO.getdado().getA() < 0){
														sleep(20);
													}
														sleep(1000);
														label_2.setVisible(false);
														label_2.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
													if(contadorDAO.getdado().getA() == 6) {
														lblRound.setText("ROUND");
														contadorDAO.getdado().setA(-1);
													}else {
														lblRound.setText("DERROTA");
														nu = 12;
														contadorDAO.getdado().setA(-1);
														break;
													}
												}
							/* 70% de chance de dar nocaute */
												else if(gerador.nextInt(10) > 2 - sorte) {
													lblRound.setText("Nocaute");
													label_3.setVisible(true);
													ControleFase2 cf2 = new ControleFase2(view);
													cf2.dado(label_3);
														sleep(1000);
														label_3.setVisible(false);
														label_3.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
													if(contadorDAO.getdado().getA() == 6) {
														lblRound.setText("ROUND");
														contadorDAO.getdado().setA(-1);
													}else {
				                                        lblRound.setText("VITORIA");
														nu = 12;
														contadorDAO.getdado().setA(-1);
														break;
													}
												}
											}
											else {
							/* 70% de chance de dar nocaute */
												if(gerador.nextInt(10) > 2 - sorte) {
													lblRound.setText("Nocaute");
													label_3.setVisible(true);
													sleep(2000);
													ControleFase2 cf2 = new ControleFase2(view);
													cf2.dado(label_3);
														sleep(1000);
														label_3.setVisible(false);
														label_3.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
													if(contadorDAO.getdado().getA() == 6) {
														lblRound.setText("ROUND");
														contadorDAO.getdado().setA(-1);
													}else {
				                                        lblRound.setText("VITORIA");
														nu = 12;
														contadorDAO.getdado().setA(-1);
														break;
													}
												}
							/* 70% de chance de tomar nocaute*/
												else if(gerador.nextInt(10) > 2) {
													lblRound.setText("Nocaute");
													label_2.setVisible(true);
													while(contadorDAO.getdado().getA() < 0){
														sleep(20);
													}
														sleep(1000);
														label_2.setVisible(false);
														label_2.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
													if(contadorDAO.getdado().getA() == 6) {
														lblRound.setText("ROUND");
														contadorDAO.getdado().setA(-1);
													}else {
														lblRound.setText("DERROTA");
														nu = 12;
														contadorDAO.getdado().setA(-1);
														break;
													}
												}
											}
										}
							 
							//Oponente com a força igual a resistencia do lutador
										else if(Oponente.getForca() == lutador.getResistencia() && gerador.nextInt(10)==2) {
											
						    /* 70% de chance de dar nocaute */
											if(gerador.nextInt(10) > 2 - sorte) {
												lblRound.setText("Nocaute");
												label_3.setVisible(true);
												sleep(2000);
												ControleFase2 cf2 = new ControleFase2(view);
												cf2.dado(label_3);
													sleep(1000);
													label_3.setVisible(false);
													label_3.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
												if(contadorDAO.getdado().getA() == 6) {
													lblRound.setText("ROUND");
													contadorDAO.getdado().setA(-1);
												}else {
			                                        lblRound.setText("VITORIA");
													nu = 12;
													contadorDAO.getdado().setA(-1);
													break;
												}
											}
						  /* 40% de chance de tomar nocaute*/
											else if(gerador.nextInt(10) > 5) {
												lblRound.setText("Nocaute");
												label_2.setVisible(true);
												while(contadorDAO.getdado().getA() < 0){
													sleep(20);
												}
													sleep(1000);
													label_2.setVisible(false);
													label_2.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
												if(contadorDAO.getdado().getA() == 6) {
													lblRound.setText("ROUND");
													contadorDAO.getdado().setA(-1);
												}else {
													lblRound.setText("DERROTA");
													nu = 12;
													contadorDAO.getdado().setA(-1);
													break;
												}
											}
										}
									}
							//Oponente com a força menor q a resistencia
										else if(Oponente.getForca() < lutador.getResistencia() && gerador.nextInt(10)==2) {
											
							/* 70% de chance de dar nocaute */				
											if(gerador.nextInt(10) > 2 - sorte) {
												lblRound.setText("Nocaute");
												label_3.setVisible(true);
												sleep(2000);
												ControleFase2 cf2 = new ControleFase2(view);
												cf2.dado(label_3);
													sleep(1000);
													label_3.setVisible(false);
													label_3.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
												if(contadorDAO.getdado().getA() == 6) {
													lblRound.setText("ROUND");
													contadorDAO.getdado().setA(-1);
												}else {
			                                        lblRound.setText("VITORIA");
													nu = 12;
													contadorDAO.getdado().setA(-1);
													break;
												}
											}
							/* 20% de chance de tomar nocaute*/
											else if(gerador.nextInt(10) > 7) {
												lblRound.setText("Nocaute");
												label_2.setVisible(true);
												while(contadorDAO.getdado().getA() < 0){
													sleep(20);
												}
													sleep(1000);
													label_2.setVisible(false);
													label_2.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
												if(contadorDAO.getdado().getA() == 6) {
													lblRound.setText("ROUND");
													contadorDAO.getdado().setA(-1);
												}else {
													lblRound.setText("DERROTA");
													nu = 12;
													contadorDAO.getdado().setA(-1);
													break;
												}
											}
									}
									
		//lutador com força igual a resistencia do oponente
									else if(lutador.getForca() == Oponente.getResistencia()) {
										
							//Oponente mais forte q a resistencia do lutador
										if(Oponente.getForca() > lutador.getResistencia() && gerador.nextInt(10)==2) {
											
							/* 70% de chance de tomar nocaute*/	
											if(gerador.nextInt(10) > 2) {
												lblRound.setText("Nocaute");
												label_2.setVisible(true);
												while(contadorDAO.getdado().getA() < 0){
													sleep(20);
												}
													sleep(1000);
													label_2.setVisible(false);
													label_2.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
												if(contadorDAO.getdado().getA() == 6) {
													lblRound.setText("ROUND");
													contadorDAO.getdado().setA(-1);
												}else {
													lblRound.setText("DERROTA");
													nu = 12;
													contadorDAO.getdado().setA(-1);
													break;
												}
											}
					        /* 40% de chance de dar nocaute */
											else if(gerador.nextInt(10) > 5 - sorte) {
												lblRound.setText("Nocaute");
												label_3.setVisible(true);
												sleep(2000);
												ControleFase2 cf2 = new ControleFase2(view);
												cf2.dado(label_3);
													sleep(1000);
													label_3.setVisible(false);
													label_3.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
												if(contadorDAO.getdado().getA() == 6) {
													lblRound.setText("ROUND");
													contadorDAO.getdado().setA(-1);
												}else {
			                                        lblRound.setText("VITORIA");
													nu = 12;
													contadorDAO.getdado().setA(-1);
													break;
												}
											}
										}
										
							//Oponente com a força igual a resistencia do lutador
										else if(Oponente.getForca() == lutador.getResistencia() && gerador.nextInt(10)==2) {
											
							//desempate por tecnica, pra ver quem tem chance de nocautear pimeiro
											if(Oponente.getTecnica() > lutador.getTecnica()) {
												
							/* 40% de chance de tomar nocaute*/
												if(gerador.nextInt(10) > 5) {
													lblRound.setText("Nocaute");
													label_2.setVisible(true);
													while(contadorDAO.getdado().getA() < 0){
														sleep(20);
													}
														sleep(1000);
														label_2.setVisible(false);
														label_2.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
													if(contadorDAO.getdado().getA() == 6) {
														lblRound.setText("ROUND");
														contadorDAO.getdado().setA(-1);
													}else {
														lblRound.setText("DERROTA");
														nu = 12;
														contadorDAO.getdado().setA(-1);
														break;
													}
												}
							/* 40% de chance de dar nocaute */ 
												else if(gerador.nextInt(10) > 5 - sorte) {
													lblRound.setText("Nocaute");
													label_3.setVisible(true);
													sleep(2000);
													ControleFase2 cf2 = new ControleFase2(view);
													cf2.dado(label_3);
														sleep(1000);
														label_3.setVisible(false);
														label_3.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
													if(contadorDAO.getdado().getA() == 6) {
														lblRound.setText("ROUND");
														contadorDAO.getdado().setA(-1);
													}else {
				                                        lblRound.setText("VITORIA");
														nu = 12;
														contadorDAO.getdado().setA(-1);
														break;
													}
												}
											}
											else {
							/* 40% de chance de dar nocaute */
												if(gerador.nextInt(10) > 5 - sorte) {
													lblRound.setText("Nocaute");
													label_3.setVisible(true);
													sleep(2000);
													ControleFase2 cf2 = new ControleFase2(view);
													cf2.dado(label_3);
														sleep(1000);
														label_3.setVisible(false);
														label_3.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
													if(contadorDAO.getdado().getA() == 6) {
														lblRound.setText("ROUND");
														contadorDAO.getdado().setA(-1);
													}else {
				                                        lblRound.setText("VITORIA");
														nu = 12;
														contadorDAO.getdado().setA(-1);
														break;
													}
												}
							/* 40% de chance de tomar nocaute*/
												else if(gerador.nextInt(10) > 5) {
													lblRound.setText("Nocaute");
													label_2.setVisible(true);
													while(contadorDAO.getdado().getA() < 0){
														sleep(20);
													}
														sleep(1000);
														label_2.setVisible(false);
														label_2.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
													if(contadorDAO.getdado().getA() == 6) {
														lblRound.setText("ROUND");
														contadorDAO.getdado().setA(-1);
													}else {
														lblRound.setText("DERROTA");
														nu = 12;
														contadorDAO.getdado().setA(-1);
														break;
													}
												}
											}
										}
							//Oponente com a força menor q a resistencia do lutador
										else if(Oponente.getForca() < lutador.getResistencia() && gerador.nextInt(10)==2) {
											
							/* 40% de chance de dar nocaute */
											if(gerador.nextInt(10) > 5 - sorte)  {
												lblRound.setText("VITORIA");
												nu = 12;
												break;
											}
						   /* 20% de chance de tomar nocaute*/
											else if(gerador.nextInt(10) > 7) {
												lblRound.setText("Nocaute");
												label_2.setVisible(true);
												while(contadorDAO.getdado().getA() < 0){
													sleep(20);
												}
													sleep(1000);
													label_2.setVisible(false);
													label_2.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
												if(contadorDAO.getdado().getA() == 6) {
													lblRound.setText("ROUND");
													contadorDAO.getdado().setA(-1);
												}else {
													lblRound.setText("DERROTA");
													nu = 12;
													contadorDAO.getdado().setA(-1);
													break;
												}
											}
										}
									}
									
			//lutador mais fraco q a resistencia do oponente
									else if(lutador.getForca() < Oponente.getResistencia()) {
										
							//Oponente mais forte q a resistencia do lutador
										if(Oponente.getForca() > lutador.getResistencia() && gerador.nextInt(10)==2) {
											
							/* 70% de chance de tomar nocaute*/	
											if(gerador.nextInt(10) > 2) {
												lblRound.setText("Nocaute");
												label_2.setVisible(true);
												while(contadorDAO.getdado().getA() < 0){
													sleep(20);
												}
													sleep(1000);
													label_2.setVisible(false);
													label_2.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
												if(contadorDAO.getdado().getA() == 6) {
													lblRound.setText("ROUND");
													contadorDAO.getdado().setA(-1);
												}else {
													lblRound.setText("DERROTA");
													nu = 12;
													contadorDAO.getdado().setA(-1);
													break;
												}
											}
							/* 20% de chance de dar nocaute */
											else if(gerador.nextInt(10) > 7 - sorte) {
												lblRound.setText("Nocaute");
												label_3.setVisible(true);
												sleep(2000);
												ControleFase2 cf2 = new ControleFase2(view);
												cf2.dado(label_3);
													sleep(1000);
													label_3.setVisible(false);
													label_3.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
												if(contadorDAO.getdado().getA() == 6) {
													lblRound.setText("ROUND");
													contadorDAO.getdado().setA(-1);
												}else {
			                                        lblRound.setText("VITORIA");
													nu = 12;
													contadorDAO.getdado().setA(-1);
													break;
												}
											}
											
										}
										
							//Oponente com a força igual a resistencia do lutador
										else if(Oponente.getForca() == lutador.getResistencia() && gerador.nextInt(10)==2) {
											
							/* 40% de chance de tomar nocaute*/			
											if(gerador.nextInt(10) > 5) {
												lblRound.setText("Nocaute");
												label_2.setVisible(true);
												while(contadorDAO.getdado().getA() < 0){
													sleep(20);
												}
													sleep(1000);
													label_2.setVisible(false);
													label_2.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
												if(contadorDAO.getdado().getA() == 6) {
													lblRound.setText("ROUND");
													contadorDAO.getdado().setA(-1);
												}else {
													lblRound.setText("DERROTA");
													nu = 12;
													contadorDAO.getdado().setA(-1);
													break;
												}
											}
							/* 20% de chance de dar nocaute */
											else if(gerador.nextInt(10) > 7 - sorte)  {
												lblRound.setText("Nocaute");
												label_3.setVisible(true);
												sleep(2000);
												ControleFase2 cf2 = new ControleFase2(view);
												cf2.dado(label_3);
													sleep(1000);
													label_3.setVisible(false);
													label_3.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
												if(contadorDAO.getdado().getA() == 6) {
													lblRound.setText("ROUND");
													contadorDAO.getdado().setA(-1);
												}else {
			                                        lblRound.setText("VITORIA");
													nu = 12;
													contadorDAO.getdado().setA(-1);
													break;
												}
											}
										}
										
						   //Oponente com a força menor q a resistencia do lutador
										else if(Oponente.getForca() < lutador.getResistencia() && gerador.nextInt(10)==2) {
											
						   //desempate por tecnica pra ver quem tem chance de nocautear primeiro
											if(Oponente.getTecnica() > lutador.getTecnica()) {
												
							/* 20% de chance de tomar nocaute*/
												if(gerador.nextInt(10) > 7) {
													lblRound.setText("Nocaute");
													label_2.setVisible(true);
													while(contadorDAO.getdado().getA() < 0){
														sleep(20);
													}
														sleep(1000);
														label_2.setVisible(false);
														label_2.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
													if(contadorDAO.getdado().getA() == 6) {
														lblRound.setText("ROUND");
														contadorDAO.getdado().setA(-1);
													}else {
														lblRound.setText("DERROTA");
														nu = 12;
														contadorDAO.getdado().setA(-1);
														break;
													}
												}
								/* 20% de chance de dar nocaute */
												else if(gerador.nextInt(10) > 7 - sorte)  {
													lblRound.setText("Nocaute");
													label_3.setVisible(true);
													sleep(2000);
													ControleFase2 cf2 = new ControleFase2(view);
													cf2.dado(label_3);
														sleep(1000);
														label_3.setVisible(false);
														label_3.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
													if(contadorDAO.getdado().getA() == 6) {
														lblRound.setText("ROUND");
														contadorDAO.getdado().setA(-1);
													}else {
				                                        lblRound.setText("VITORIA");
														nu = 12;
														contadorDAO.getdado().setA(-1);
														break;
													}
												}
											}
											else {
								/* 20% de chance de dar nocaute */
												if(gerador.nextInt(10) > 7 - sorte)  {
													lblRound.setText("Nocaute");
													label_3.setVisible(true);
													sleep(2000);
													ControleFase2 cf2 = new ControleFase2(view);
													cf2.dado(label_3);
														sleep(1000);
														label_3.setVisible(false);
														label_3.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
													if(contadorDAO.getdado().getA() == 6) {
														lblRound.setText("ROUND");
														contadorDAO.getdado().setA(-1);
													}else {
				                                        lblRound.setText("VITORIA");
														nu = 12;
														contadorDAO.getdado().setA(-1);
														break;
													}
												}
								/* 20% de chance de tomar nocaute*/
												else if(gerador.nextInt(10) > 7) {
													lblRound.setText("Nocaute");
													label_2.setVisible(true);
													while(contadorDAO.getdado().getA() < 0){
														sleep(20);
													}
														sleep(1000);
														label_2.setVisible(false);
														label_2.setIcon(new ImageIcon("C:\\Users\\Warlley\\git\\Jogo-Box\\jogao\\src\\View\\imagens\\dadinho.gif"));	
													if(contadorDAO.getdado().getA() == 6) {
														lblRound.setText("ROUND");
														contadorDAO.getdado().setA(-1);
													}else {
														lblRound.setText("DERROTA");
														nu = 12;
														contadorDAO.getdado().setA(-1);
														break;
													}
												}
											}
										}	
									}
								}
								progressBar.setValue(progressBar.getValue()+1);
								} catch (InterruptedException e) {
									e.printStackTrace();
									}
							}
						
						if(nu==12) {
							btnNewButton.setText("voltar");
							}
						}
					}
				}
			}.start();;
			}
	}
