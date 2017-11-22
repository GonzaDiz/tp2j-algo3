package modelo.casillero.especial;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class ImpuestoDeLujo extends Casillero {
	
	private int porcentajeDeImpuesto = 10;

	public ImpuestoDeLujo() {
		super();
		this.nombreCasillero = "Impuesto De Lujo";

	}
	
	@Override
	public void afectarJugador(Jugador unJugador) {
		unJugador.extraerDinero(unJugador.capitalTotal()*(this.porcentajeDeImpuesto/100));
	}

}
