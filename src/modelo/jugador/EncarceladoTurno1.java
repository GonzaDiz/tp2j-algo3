package modelo.jugador;

import modelo.Turno;
import modelo.casillero.especial.Carcel;
import modelo.excepciones.NoPuedePagarFianzaException;
import modelo.excepciones.NoSePuedeDesplazarJugadorEncarceladoException;

public class EncarceladoTurno1 implements EstadoJugador {

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
	
	@Override
	public void terminarTurno(Turno turno, Jugador jugador) {
		turno.terminarTurno(jugador);
	}

	@Override
	public boolean puedoPagarFianza() {
		return false;
	}

	@Override
	public boolean noPuedoTirarDados() {
		return true;
	}

}
