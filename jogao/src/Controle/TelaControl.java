package Controle;

import View.Opcao;
import View.Tela;
import View.Tela2;

public class TelaControl {

	private final Tela view;
	
	public TelaControl(Tela view) {
		this.view = view;
	}
	/**
	 * Função que abre a janela Opção
	 */
	public void abrirOpcao() {
		Opcao.main(null);
	}
	/**
	 * Função que abre a janela Tela2
	 */
	public void abrirTela2() {
		Tela2.main(null);
	}
	/**
	 * Função que fecha Tela
	 */
	public void fecharTela() {
		view.dispose();
	}
}
