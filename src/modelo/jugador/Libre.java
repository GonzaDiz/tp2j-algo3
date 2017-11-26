package modelo.jugador;

import modelo.Tablero;
import modelo.Turno;
import modelo.casillero.especial.Carcel;
import modelo.excepciones.NoEstasEncarceladoException;

public class Libre implements EstadoJugador {

	@Override
	public void desplazar(Jugador unJugador, int cantidadDeCasilleros) {
		// Si no se tiene que desplazar, el casillero actual no lo debe tener que volver a afectar
		if(cantidadDeCasilleros == 0) {
			return;
		}
		else {
			Tablero tablero = Tablero.getInstance();
			unJugador.caerEnCasillero(tablero.getCasilleroPorDesplazamiento(unJugador.casilleroActual(), cantidadDeCasilleros));
		}
	}

	@Override
	public void actualizarEstado(Jugador jugador) {
		
	}


	@Override
	public void pagarFianza(Jugador jugador, Carcel unaCarcel) {
		throw new NoEstasEncarceladoException();
	}

	@Override
	public void terminarTurno(Turno turno, Jugador jugador) {
		turno.terminarTurno(jugador);
	}

}
