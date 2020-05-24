package Controle;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import ControleHelper.Helper;
import Model.Lutador;
import Model.DAO.LutadorDAO;
import View.Fase1;
import View.NovoJogo;

public class NJControle {
	
	private Helper helper;
	private final NovoJogo view;
	
	public NJControle(NovoJogo view) {
		this.view = view;
		this.helper = new Helper(view);
	}
	/**
	 * Cria um novo Objeto Lutador com ajuda da clase  "helper", confere se ja existe um lutador com o mesmo nome no banco de dados, 
	 * e se o nome é diferente de vazio, depois disso abre a Janela Fase1 e fecha a NovoJogo
	 * @param boxPais
	 * @param spinner
	 * @param spinner1
	 * @param spinner2
	 * @param spinner3
	 */
	public void abrirFase1(JComboBox boxPais, JSpinner spinner,JSpinner spinner1,JSpinner spinner2,JSpinner spinner3 ) {
		LutadorDAO lutadorDAO = new LutadorDAO();
		Lutador lutador = helper.obterLutador(boxPais, spinner, spinner1, spinner2, spinner3);
		if( lutador.getNome().isEmpty() != true) {
			if(lutadorDAO.compare(lutador) != true) {
				lutadorDAO.insert(lutador);
				Fase1.main(null);
				view.dispose();
				}
			else {
				String message = "Já existe um Lutador com a mesma ID";
				JOptionPane.showMessageDialog(null, message);		
			}
			}
		else {
			String message = "Insira um Nome!";
			JOptionPane.showMessageDialog(null, message);
			}
		}
}
