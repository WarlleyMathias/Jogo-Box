package Controle;

import View.Fase1;
import View.Opcao;
import View.Tela;
import View.Tela2;

public class TelaControl {

	private final Tela view;
	
	public TelaControl(Tela view) {
		this.view = view;
	}
	
	public void abrirOpcao() {
		Opcao.main(null);
	}
	
	public void abrirTela2() {
		Tela2.main(null);
	}
	
	public void fecharTela() {
		view.dispose();
	}
}
