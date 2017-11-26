package modelo;

import modelo.jugador.Jugador;
import modelo.jugador.Libre;
import modelo.jugador.TurnoExtra;

public class TiroDoble implements TiroDeDados{
	
	private int valorDeDados;
	
	public TiroDoble(int valorDeDados) {
		this.valorDeDados = valorDeDados;
	}

	@Override
	public int valor() {
		return this.valorDeDados;
	}
	
	public void actualizarEstado(Jugador jugador, TiroDeDados tiroDados) {
		if (tiroDados.sosDoble()) {
			jugador.cambiarEstado(new Libre());
		}
		else {
			jugador.cambiarEstado(new TurnoExtra());
		}
	}

	@Override
	public boolean sosDoble() {
		return true;
	}
}
