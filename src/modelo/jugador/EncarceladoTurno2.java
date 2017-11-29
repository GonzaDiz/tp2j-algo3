package modelo.jugador;

import modelo.Turno;
import modelo.casillero.especial.Carcel;
import modelo.excepciones.NoSePuedeDesplazarJugadorEncarceladoException;

public class EncarceladoTurno2 implements EstadoJugador{
	

	@Override
	public void desplazar(Jugador unJugador, int cantidadDeCasilleros) {
		throw new NoSePuedeDesplazarJugadorEncarceladoException();
	}

	@Override
	public void actualizarEstado(Jugador jugador) {
		EncarceladoTurno3 encarceladoTurno3 = new EncarceladoTurno3();
		jugador.cambiarEstado(encarceladoTurno3);
		
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
