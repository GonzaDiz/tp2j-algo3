package modelo.casillero.especial;

import modelo.casillero.Casillero;
import modelo.excepciones.NoEsUnCasilleroComprableError;
import modelo.jugador.Jugador;

public class Policia extends Casillero {
	
	private Carcel carcel;
	
	public Policia() {
		super();
		this.nombreCasillero = "Policia";

	}
	
	public Policia(Carcel unaCarcel) {
		this.carcel = unaCarcel;
		this.nombreCasillero = "Policia";
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		unJugador.caerEnCasillero(this.carcel);
	}

	@Override
	public void comprar(Jugador unJugador) {
		throw new NoEsUnCasilleroComprableError("El casillero en el que se encuentra no puede ser comprado");
	}
	
	@Override
	public boolean sosComprable() {
		return false;
	}
}
