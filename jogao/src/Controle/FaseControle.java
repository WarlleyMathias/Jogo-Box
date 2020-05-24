package Controle;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import Model.Contador;
import Model.Data;
import Model.Lutador;
import Model.DAO.ContadorDAO;
import Model.DAO.DataDAO;
import View.Fase1;
import View.Fase2;

public class FaseControle {
	private final Fase1 view;
	DataDAO dataDAO = new DataDAO();
	Data data1      = dataDAO.getData();
	
	public FaseControle(Fase1 view) {
		this.view = view;
		
	}
	/**
	 * Deixa o botão "Proxima Luta" visivel
	 * @param proximaLuta
	 */
	public void proxluta(JButton proximaLuta) {
		proximaLuta.setVisible(true);
	}
	/**
	 * Deixa o botão "Proxima Luta" invisivel
	 * @param proximaLuta
	 */
	public void proxluta2(JButton proximaLuta) {
		proximaLuta.setVisible(false);
	}
	/**
	 * Abre a janela interna preLuta
	 * @param preLuta
	 */
	public void preLuta(JInternalFrame preLuta) {
		preLuta.setVisible(true);
	}
	/**
	 * Fecha a janela interna preLuta
	 * @param preLuta
	 */
	public void preLuta2(JInternalFrame preLuta) {
		preLuta.setVisible(false);
	}
	/**
	 * Abre a janela interna Patrocinio
	 * @param janelaPatrocinio
	 */
	public void patrocinio(JInternalFrame janelaPatrocinio) {
		janelaPatrocinio.setVisible(true);		
	}
	/**
	 * Fecha a janela interna Patrocinio
	 * @param janelaPatrocinio
	 */
	public void patrocinioClose(JInternalFrame janelaPatrocinio) {
		janelaPatrocinio.setVisible(false);
	}
	/**
	 * Abre a janela interna Treino
	 * @param janelaTreino
	 */
	public void treino(JInternalFrame janelaTreino) {
		janelaTreino.setVisible(true);
	}
	/**
	 * Fecha a janela interna Treino
	 * @param janelaTreino
	 */
	public void treinoClose(JInternalFrame janelaTreino) {
		janelaTreino.setVisible(false);	
	}
	/**
	 * Trava o botão Patrocinio
	 * @param btnPatrocinio
	 */
	public void travarBotao(JButton btnPatrocinio) {
		btnPatrocinio.setEnabled(false);
	}
	/**
	 * Trava o botão Treino
	 * @param btnTreino
	 */
	public void travarBotao2(JButton btnTreino) {
		btnTreino.setEnabled(false);
	}
	/**
	 * Destrava o botão Patrocinio
	 * @param btnPatrocinio
	 */
	public void destravarBotao(JButton btnPatrocinio) {
		btnPatrocinio.setEnabled(true);
	}
	/**
	 * Destrava o botão Treino
	 * @param btnTreino
	 */
	public void destravarBotao2(JButton btnTreino) {
		btnTreino.setEnabled(true);
	}
	/**
	 * Atualiza a Data do jogo, e abre a janela Fase2
	 * @param lblNewLabel
	 */
	public void abrirFase2(JLabel lblNewLabel) {

		if(data1.getDd()==30) {
			data1.setDd(0);
			if(data1.getMm()!= 12) {
				data1.setMm(data1.getMm()+1);	
			}
			else if(data1.getMm()==12) {
				data1.setMm(1);
				data1.setAa(data1.getAa()+1);
			}
		}
		Data data       = new Data(data1.getDd()+1,data1.getMm(),data1.getAa());
		dataDAO.update(data);
		Fase2.main(null);
		view.dispose();
		;
	}
	/**
	 * Faz a função do Botão treinarForca
	 * @param label_2
	 * @param btnTreinoDeFora
	 * @param btnTreinarTecnica
	 */
	public void treinarForca(JLabel label_2, JButton btnTreinoDeFora,JButton btnTreinarTecnica) {
		ContadorDAO contadorDAO = new ContadorDAO();
		contadorDAO.getContador().setA(3);
		label_2.setText("fim do treino em: "+contadorDAO.getContador().getA()+" dias");
		btnTreinoDeFora.setEnabled(false);
		btnTreinarTecnica.setEnabled(false);
	}
	/**
	 * Faz a função do Botão treinarTecnica
	 * @param label_2
	 * @param btnTreinoDeFora
	 * @param btnTreinarTecnica
	 */
	public void treinarTecnica(JLabel label_2, JButton btnTreinoDeFora,JButton btnTreinarTecnica) {
		ContadorDAO contadorDAO = new ContadorDAO();
		contadorDAO.getContador2().setA(3);
		label_2.setText("fim do treino em: "+contadorDAO.getContador2().getA()+" dias");
		btnTreinoDeFora.setEnabled(false);
		btnTreinarTecnica.setEnabled(false);
	}
	/**
	 * Continua a tarefa do botão treinarTecnica
	 * @param lutador
	 * @param contadorDAO
	 * @param lblTecnica
	 * @param btnTreinoDeFora
	 * @param btnTreinarTecnica
	 */
	public void contador2(Lutador lutador, ContadorDAO contadorDAO, JLabel lblTecnica, JButton btnTreinoDeFora, JButton btnTreinarTecnica) {
		if(contadorDAO.getContador2().getA()==0) {
			lutador.setTecnica(lutador.getTecnica()+1);
			lblTecnica.setText("Tecnica: "+lutador.getTecnica());
			contadorDAO.getContador2().setA(-1);
			btnTreinoDeFora.setEnabled(true);
			btnTreinarTecnica.setEnabled(true);
		}
	}
	/**
	 * Continua a tarefa do botão treinarTecnica
	 * @param lutador
	 * @param contadorDAO
	 * @param lblForca
	 * @param btnTreinoDeFora
	 * @param btnTreinarTecnica
	 */
	public void contador1(Lutador lutador, ContadorDAO contadorDAO, JLabel lblForca, JButton btnTreinoDeFora, JButton btnTreinarTecnica) {
		if(contadorDAO.getContador().getA()==0) {
			lutador.setForca(lutador.getForca()+1);
			lblForca.setText("Forca: "+lutador.getForca());
			contadorDAO.getContador().setA(-1);
			btnTreinoDeFora.setEnabled(true);
			btnTreinarTecnica.setEnabled(true);
		}
	}
	/**
	 * Trava os botões TreinarForca e TreinaTecnica, caso o contador for maior que 0
	 * @param contadorDAO
	 * @param btnTreinarTecnica
	 * @param btnTreinoDeFora
	 */
	public void enabledBtn(ContadorDAO contadorDAO, JButton btnTreinarTecnica, JButton btnTreinoDeFora) {
		if(contadorDAO.getContador().getA()>0 || contadorDAO.getContador2().getA()>0) {
			btnTreinarTecnica.setEnabled(false);
		    btnTreinoDeFora.setEnabled(false);
		}
	}
	/**
	 * Diminui o contador, e exibe o valor do contador
	 * @param contadorDAO
	 * @param label_2
	 */
	public void faltam(ContadorDAO contadorDAO, JLabel label_2) {
		if(contadorDAO.getContador().getA()>0 ) {
			contadorDAO.getContador().setA(contadorDAO.getContador().getA()-1);
			if(contadorDAO.getContador().getA()>0) {
				label_2.setText("fim do treino em: "+contadorDAO.getContador().getA()+" dias");
			}
			}
		else if(contadorDAO.getContador2().getA()>0 ) {
			contadorDAO.getContador2().setA(contadorDAO.getContador2().getA()-1);
			if(contadorDAO.getContador2().getA()>0) {
				label_2.setText("fim do treino em: "+contadorDAO.getContador2().getA()+" dias");
			}
			}
	}
	/**
	 * Carrega o banco de dado com o estilo de luta
	 * @param comboBox
	 */
	public void getEstilo(JComboBox comboBox) {
		ContadorDAO contadorDAO = new ContadorDAO();
		if (comboBox.getSelectedItem().toString() == "Ofensivo") {
			contadorDAO.getEstilo().setA(1);
		}
		else if (comboBox.getSelectedItem().toString() == "Defensivo") {
			contadorDAO.getEstilo().setA(2);
		}
		else if (comboBox.getSelectedItem().toString() == "Equilibrado") {
			contadorDAO.getEstilo().setA(3);
		}
		
	}
}
