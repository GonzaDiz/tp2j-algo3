package modelo.jugador;

import modelo.Turno;
import modelo.casillero.especial.Carcel;
import modelo.excepciones.NoSePuedeDesplazarJugadorEncarceladoException;

public class EncarceladoTurno3 implements EstadoJugador {

	@Override
	public void desplazar(Jugador unJugador, int cantidadDeCasilleros) {
		throw new NoSePuedeDesplazarJugadorEncarceladoException();
	}

	@Override
	public void actualizarEstado(Jugador jugador) {
		EstadoJugador libre = new Libre();
		jugador.cambiarEstado(libre);
		
	}

	@Override
	public void pagarFianza(Jugador jugador, Carcel unaCarcel) {
		unaCarcel.cobrarFianza(jugador);
	}

	@Override
	public void terminarTurno(Turno turno, Jugador jugador) {
		turno.terminarTurno(jugador);
	}

	@Override
	public boolean puedoPagarFianza() {
		return true;
	}

	@Override
	public boolean noPuedoTirarDados() {
		return true;
	}
}
