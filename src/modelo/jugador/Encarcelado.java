package modelo.jugador;

import modelo.casillero.especial.Carcel;
import modelo.excepciones.NoPuedePagarFianzaException;
import modelo.excepciones.NoSePuedeDesplazarJugadorEncarceladoException;

public class Encarcelado extends EstadoJugador {

	private int turnosEnCarcel;
	
	public Encarcelado() {
		this.turnosEnCarcel = 0;
	}
	
	@Override
	public void desplazar(Jugador unJugador, int cantidadDecasilleros) {
		throw new NoSePuedeDesplazarJugadorEncarceladoException();
	}

	@Override
	public void actualizarEstado(Jugador jugador) {
		turnosEnCarcel++;
		if(turnosEnCarcel == 4) {
			jugador.liberar();
		}
	}

	@Override
	public void pagarFianza(Jugador jugador) {
		if(turnosEnCarcel <= 1) {
			throw new NoPuedePagarFianzaException();
		}
		Carcel carcel = Carcel.getCarcel();
		carcel.cobrarFianza(jugador);
		
	}


}
