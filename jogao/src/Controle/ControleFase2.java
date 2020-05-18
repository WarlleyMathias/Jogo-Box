package Controle;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import Model.Lutador;
import Model.DAO.LutadorDAO;
import View.Fase2;

public class ControleFase2 {
	LutadorDAO lutadorDAO = new LutadorDAO();
	Lutador lutador = lutadorDAO.getLutador();
	Lutador Oponente = lutadorDAO.getOponente();
	
	
	
	
	
	
	private final Fase2 view;
	
	public ControleFase2(Fase2 view) {
		this.view = view;
		
		
		
		
	}

	public void lutar() {

		if(lutador.getForca()>Oponente.getForca()) {
			JOptionPane.showMessageDialog(null, "vitoria");
		}
		
	}
}
