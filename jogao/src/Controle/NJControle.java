package Controle;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

import ControleHelper.Helper;
import Model.Lutador;
import Model.DAO.Banco;
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

	public void abrirFase1(JComboBox boxPais, JSpinner spinner,JSpinner spinner1,JSpinner spinner2,JSpinner spinner3 ) {
		LutadorDAO lutadorDAO = new LutadorDAO();
		//pegar Nome, pais e etc
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
