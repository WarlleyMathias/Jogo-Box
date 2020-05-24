package Controle;

import View.NovoJogo;
import View.Tela;
import View.Tela2;

public class Tela2Control {
	private final Tela2 view;
	
	public Tela2Control(Tela2 view) {
		this.view = view;
	}
	/**
	 * Função que abre a janela Tela, e fecha a janela Tela2
	 */
	public void abrirTela() {
		Tela.main(null);
		view.dispose();
	}
	/**
	 * Função que abre a janela NovoJogo, e fecha a janela Tela2
	 */
	public void abrirNJ() {
		NovoJogo.main(null);
		view.dispose();
	}
}
