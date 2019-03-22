package loja.Principal;

import loja.Interface.LojaConsole;
import loja.entidades.Loja;

public class Principal {

	public static void main(String[] args) {
		Loja loja = new Loja();
		LojaConsole lj = new LojaConsole(loja);
		lj.iniciar();
	}

}
