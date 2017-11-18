package modelo.jugador;

import modelo.casillero.especial.Carcel;
import modelo.excepciones.NoSePuedeDesplazarJugadorEncarceladoException;

public class EncarceladoTurno3 extends EstadoJugador {

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

}
