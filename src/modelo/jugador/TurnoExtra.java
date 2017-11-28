package modelo.jugador;

import modelo.Tablero;
import modelo.Turno;
import modelo.casillero.especial.Carcel;

public class TurnoExtra implements EstadoJugador {
	
	@Override
	public void desplazar(Jugador unJugador, int cantidadDeCasilleros) {
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
	}

	@Override
	public void terminarTurno(Turno turno, Jugador jugador) {
		turno.asignarTurnoExtra(jugador);
	}

	@Override
	public boolean puedoPagarFianza() {
		return false;
	}

	@Override
	public boolean noPuedoTirarDados() {
		return false;
	}

}
