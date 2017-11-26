package modelo.jugador;

import modelo.Turno;
import modelo.casillero.especial.Carcel;

public class TurnoExtra implements EstadoJugador {
	
	@Override
	public void desplazar(Jugador unJugador, int cantidadDeCasilleros) {
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

}
