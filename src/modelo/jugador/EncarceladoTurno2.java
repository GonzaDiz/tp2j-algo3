package modelo.jugador;

import modelo.casillero.especial.Carcel;
import modelo.excepciones.NoSePuedeDesplazarJugadorEncarceladoException;

public class EncarceladoTurno2 extends EstadoJugador{

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
	public void pagarFianza(Jugador jugador) {
		Carcel carcel = Carcel.getCarcel();
		carcel.cobrarFianza(jugador);
		
	}

}
