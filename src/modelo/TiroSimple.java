package modelo;

import modelo.jugador.Jugador;
import modelo.jugador.Libre;

public class TiroSimple implements TiroDeDados {
	
	private int valorDeDados;
	
	public TiroSimple(int valorDeDados) {
		this.valorDeDados = valorDeDados;
	}

	@Override
	public int valor() {
		return this.valorDeDados;
	}

	@Override
	public void actualizarEstado(Jugador jugador, TiroDeDados tiroDados) {
		jugador.cambiarEstado(new Libre());
	}

	@Override
	public boolean sosDoble() {
		return false;
	}

}
