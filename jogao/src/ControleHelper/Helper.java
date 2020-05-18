package ControleHelper;

import javax.swing.JComboBox;
import javax.swing.JSpinner;

import Model.Lutador;
import View.NovoJogo;

public class Helper {

	private final NovoJogo view;
	
	public Helper(NovoJogo view) {
		this.view = view;
		
	}
	
	public Lutador obterLutador(JComboBox boxPais, JSpinner spinner,JSpinner spinner1,JSpinner spinner2,JSpinner spinner3) {
		
		int id        = 11;
		int rank      = 10;
		String pais   = boxPais.getSelectedItem().toString();
		String nome   = view.getTextNome().getText();
		int   idade   = Integer.parseInt(spinner.getValue().toString());
		int   forca   = Integer.parseInt(spinner1.getValue().toString());
		int   peso    = Integer.parseInt(spinner2.getValue().toString());
		int   tecnica = Integer.parseInt(spinner3.getValue().toString());
		Lutador lutador = new Lutador(id, rank, nome, pais, idade, forca, peso, tecnica);
		return lutador;

	}
}
