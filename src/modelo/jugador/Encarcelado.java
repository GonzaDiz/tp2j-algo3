package modelo.jugador;

import modelo.Turno;
import modelo.casillero.especial.Carcel;
import modelo.excepciones.NoPuedePagarFianzaException;
import modelo.excepciones.NoSePuedeDesplazarJugadorEncarceladoException;

public class Encarcelado implements EstadoJugador {
	
	@Override
	public void desplazar(Jugador unJugador, int cantidadDecasilleros) {
		throw new NoSePuedeDesplazarJugadorEncarceladoException();
	}

	@Override
	public void actualizarEstado(Jugador jugador) {
		EncarceladoTurno1 encarceladoPor1Turno = new EncarceladoTurno1();
		jugador.cambiarEstado(encarceladoPor1Turno);
	}

	@Override
	public void pagarFianza(Jugador jugador, Carcel unaCarcel) {
			throw new NoPuedePagarFianzaException();	
	}

	@Override
	public void terminarTurno(Turno turno, Jugador jugador) {
		turno.terminarTurno(jugador);
	}

}
