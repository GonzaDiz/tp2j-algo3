package modelo.jugador;

import modelo.Tablero;
import modelo.excepciones.NoEstasEncarceladoException;

public class Libre extends EstadoJugador {

	@Override
	public void desplazar(Jugador unJugador, int cantidadDeCasilleros) {
		// Si no se tiene que desplazar, el casillero actual no lo debe tener que volver a afectar
		if(cantidadDeCasilleros == 0) {

		}
		else {
			Tablero tablero = Tablero.getTablero();
			unJugador.caerEnCasillero(tablero.getCasillero(unJugador.casilleroActual(), cantidadDeCasilleros));
			
		}
	}

	@Override
	public void actualizarEstado(Jugador jugador) {
		
	}


	@Override
	public void pagarFianza(Jugador jugador) {
		throw new NoEstasEncarceladoException();
	}

}
