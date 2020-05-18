package Controle;

import View.Opcao;
import View.Tela;

public class OpcaoControle {

	private final Opcao view;
	
	public OpcaoControle(Opcao view) {
		this.view = view;
		
	}
	
	public void voltar() {
		Tela.main(null);
		view.dispose();
	}
}
