package modelo.jugador;

import modelo.Tablero;

public class Encarcelado extends EstadoJugador {

	private int turnosEnCarcel;
	
	public Encarcelado() {
		this.turnosEnCarcel = 0;
	}
	
	@Override
	public boolean desplazar(Jugador unJugador, int unValorDeDados) {
		Tablero tablero = Tablero.getTablero();
		unJugador.caerEnCasillero(tablero.getCasillero(unJugador.casilleroActual(), unValorDeDados));
		return false;
	}

	@Override
	public void actualizarEstado(Jugador jugador) {
		turnosEnCarcel++;
		if(turnosEnCarcel == 4) {
			jugador.liberar();
		}
	}

	@Override
	public boolean puedePagarFianza() {
		if(turnosEnCarcel <= 1) {
			return false;
		}
		return true;
	}

	@Override
	public void retroceder(Jugador jugador, int cantidadDeCasillerosARetroceder) {
		// TODO Auto-generated method stub
		
	}


}
