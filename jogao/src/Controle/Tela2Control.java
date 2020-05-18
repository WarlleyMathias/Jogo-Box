package Controle;

import View.NovoJogo;
import View.Tela;
import View.Tela2;

public class Tela2Control {
	private final Tela2 view;
	
	public Tela2Control(Tela2 view) {
		this.view = view;
	}

	public void abrirTela() {
		Tela.main(null);
	}
	
	public void tela2Close() {
		view.dispose();
	}
	
	public void abrirNJ() {
		NovoJogo.main(null);
	}
}
