package modelo.casillero.especial;

import modelo.casillero.Casillero;
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

}
