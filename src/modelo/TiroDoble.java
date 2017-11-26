package modelo;

import modelo.jugador.Jugador;
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

	@Override
	public void actualizarEstado(Jugador jugador) {
		jugador.cambiarEstado(new TurnoExtra());
		
	}

}
