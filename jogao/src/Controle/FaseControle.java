package Controle;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;

import View.Fase1;
import View.Fase2;

public class FaseControle {
	private final Fase1 view;
	
	public FaseControle(Fase1 view) {
		this.view = view;
		
	}
	
	public void proxluta(JButton proximaLuta) {
		proximaLuta.setVisible(true);
	}
	public void proxluta2(JButton proximaLuta) {
		proximaLuta.setVisible(false);
	}
	public void preLuta(JInternalFrame preLuta) {
		preLuta.setVisible(true);
	}
	public void preLuta2(JInternalFrame preLuta) {
		preLuta.setVisible(false);
	}
	
	public void patrocinio(JInternalFrame janelaPatrocinio) {
		janelaPatrocinio.setVisible(true);
		
	}
	public void patrocinioClose(JInternalFrame janelaPatrocinio) {
		janelaPatrocinio.setVisible(false);
		
	}
	public void treino(JInternalFrame janelaTreino) {
		janelaTreino.setVisible(true);
		
	}
	public void treinoClose(JInternalFrame janelaTreino) {
		janelaTreino.setVisible(false);
		
	}
	
	public void travarBotao(JButton btnPatrocinio) {
		btnPatrocinio.setEnabled(false);
	}
	public void travarBotao2(JButton btnTreino) {
		btnTreino.setEnabled(false);
	}
	public void destravarBotao(JButton btnPatrocinio) {
		btnPatrocinio.setEnabled(true);
	}
	public void destravarBotao2(JButton btnTreino) {
		btnTreino.setEnabled(true);
	}
	public void abrirFase2() {
		Fase2.main(null);
		;
	}
}
