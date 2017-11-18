package modelo.jugador;

import modelo.casillero.especial.Carcel;
import modelo.excepciones.NoPuedePagarFianzaException;
import modelo.excepciones.NoSePuedeDesplazarJugadorEncarceladoException;

public class EncarceladoTurno1 extends EstadoJugador {

	@Override
	public void desplazar(Jugador unJugador, int cantidadDeCasilleros) {
		throw new NoSePuedeDesplazarJugadorEncarceladoException();
		
	}

	@Override
	public void actualizarEstado(Jugador jugador) {
		EncarceladoTurno2 encarceladoTurno2 = new EncarceladoTurno2();
		jugador.cambiarEstado(encarceladoTurno2);
		
	}

	@Override
	public void pagarFianza(Jugador jugador, Carcel unaCarcel) {
		throw new NoPuedePagarFianzaException();
	}

}
