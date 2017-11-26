package modelo;

import modelo.jugador.Jugador;

public class SinTiro implements TiroDeDados{

	@Override
	public int valor() {
		return 0;
	}

	@Override
	public void actualizarEstado(Jugador jugador, TiroDeDados tiroDados) {
	}

	@Override
	public boolean sosDoble() {
		return false;
	}

}
